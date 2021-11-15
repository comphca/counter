package com.comphca.counter.service.Impl;

import com.comphca.counter.cache.CacheType;
import com.comphca.counter.cache.RedisStringCache;
import com.comphca.counter.common.ServerResponse;
import com.comphca.counter.dao.UserMapper;
import com.comphca.counter.pojo.User;
import com.comphca.counter.service.UserService;
import com.comphca.counter.utils.myuuid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by comphca
 * @Date 2021/10/19 1:10
 * @Description TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void updatLoginDate(long uid) {
        userMapper.updateLoginDate(uid);
    }

    @Override
    public ServerResponse login(long uid, String password, String captcha,String captchaId) {
        if (StringUtils.isAnyBlank(String.valueOf(uid),password)){
            return ServerResponse.createByErrorMessage("用户名、密码为空，不能登录");
        }

        //校验验证码
        String captchaCache = RedisStringCache.get(captchaId, CacheType.CAPTCHA);
        if (StringUtils.isEmpty(captchaCache)){
            return ServerResponse.createByErrorMessage("缓存的验证码超时");
        }
        if (!StringUtils.equalsIgnoreCase(captcha,captchaCache)){
            return ServerResponse.createByErrorMessage("验证码错误");
        }
        //检查完验证码从缓存中清空验证码
        RedisStringCache.remove(captchaId,CacheType.CAPTCHA);
        //查询数据库判断
        User user = userMapper.selectUserByIdAndPwd(uid,password);
        if (user == null){
            System.out.println("没有查到对应的用户");
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }else {
            //校验成功
            //1.先生成一个uuid唯一标志
            user.setToken(String.valueOf(myuuid.getInstance().getUUID()));
            //2.id放入缓存
            //TODO 这里放入缓存的需要放整个对象，后面通过json进行序列化和反序列化
            RedisStringCache.cache(user.getToken(),String.valueOf(uid),CacheType.ACCOUNT);
            //3.更新登录时间
            updatLoginDate(uid);
        }
        System.out.println(user.getToken());
        System.out.println("登录成功");
        return ServerResponse.cerateBySuccess("登录成功",user);

    }

    //判断对象是否在缓存中，如果在缓存中就返回一个true，否则返回false
    @Override
    public boolean accountExistInCache(String token) {
        if(StringUtils.isBlank(token)){
            return false;
        }

        //从缓存获取数据
        String acc = RedisStringCache.get(token, CacheType.ACCOUNT);
        if(acc != null){
            RedisStringCache.cache(token,acc,CacheType.ACCOUNT);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean logout(String token) {
        RedisStringCache.remove(token,CacheType.ACCOUNT);
        return true;
    }

    @Override
    public ServerResponse updatePwd(long uid, String oldpwd, String newpwd) {
        //TODO 判断旧密码和这个用户id是否能够对应上，防止横向越权

        int updatecount = userMapper.updatePwd(uid,oldpwd,newpwd);
        if (updatecount > 0){
            return ServerResponse.cerateBySuccessMessage("密码更新成功");
        }
        return ServerResponse.createByErrorMessage("密码更新失败");

    }

    @Override
    public ServerResponse getBalanceByUid(long uid) {
        /*查金额的时候可以先校验一下用户是否存在，当前登录的对象是否正确*/
        /*后面可以增加先查缓存，在查数据库，查万数据库在去更新缓存*/

        int count = userMapper.getUserByUid(uid);
        if (count > 0) {
            Long balance = userMapper.getBalanceByUid(uid);
            System.out.println("用户余额"+String.valueOf(balance) );
            return ServerResponse.createBySuccess(balance);
        }
        return ServerResponse.createByErrorMessage("该用户不存在");
    }


}
