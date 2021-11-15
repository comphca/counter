package com.comphca.counter.controller;

import com.comphca.counter.cache.CacheType;
import com.comphca.counter.cache.RedisStringCache;
import com.comphca.counter.common.CaptchaRes;
import com.comphca.counter.common.ServerResponse;
import com.comphca.counter.pojo.User;
import com.comphca.counter.service.UserService;
import com.comphca.counter.utils.CaptchaUtils;
import com.comphca.counter.utils.myuuid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Created by comphca
 * @Date 2021/10/17 14:38
 * @Description TODO
 */
@RestController
@Log4j2
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    //处理验证码请求
    @RequestMapping("/captcha")
    public ServerResponse captcha(){
        //1.生成验证码  120 40 4个字符，一些线条和干扰点
        //2.验证码放到redis，实际放的是验证码的id  <id,验证码数值>
        //3.使用base64编码图片，将生成的验证码返回给前台
        CaptchaUtils captcha = new CaptchaUtils(120,40,4,10);

        //2
        String uuid = String.valueOf(myuuid.getInstance().getUUID());
        RedisStringCache.cache(uuid,captcha.getCode(), CacheType.CAPTCHA);

        //3
        CaptchaRes captchaRes = null;
        try {
            captchaRes = new CaptchaRes(uuid,captcha.getBase64ByteStr());
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("验证码返回正常");

        return ServerResponse.createBySuccess(captchaRes);
    }


    //处理登录请求
    @RequestMapping("/userlogin")
    public ServerResponse<User> login(long uid, String password, String captcha, String captchaId ){
        ServerResponse serverResponse = userService.login(Long.valueOf(uid),password,captcha,captchaId);
        System.out.println(""+uid+","+password+","+captcha+","+captchaId);
//        System.out.println(serverResponse.getData().toString());
        System.out.println(serverResponse.getStatus());
        return serverResponse;
    }

    @RequestMapping("/loginfail")
    public ServerResponse<String> loginFail(){
        return ServerResponse.createByErrorMessage("请重新登录");
    }

    @RequestMapping("/logout")
    public ServerResponse logout(@RequestParam String token){
        userService.logout(token);
        return ServerResponse.cerateBySuccessMessage("成功退出");
    }

    @RequestMapping("/pwdupdate")
    public ServerResponse updatePwd(@RequestParam long uid, @RequestParam String oldpwd, @RequestParam String newpwd){
        return userService.updatePwd(uid,oldpwd,newpwd);
    }
}
