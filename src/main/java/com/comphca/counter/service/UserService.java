package com.comphca.counter.service;

import com.comphca.counter.common.ServerResponse;
import com.comphca.counter.pojo.User;

/**
 * @Created by comphca
 * @Date 2021/10/19 0:51
 * @Description TODO
 */
public interface UserService {
    void updatLoginDate(long uid);
    ServerResponse<User> login(long uid, String password, String captcha, String captchaId);

    boolean accountExistInCache(String token);

    boolean logout(String token);

    ServerResponse updatePwd(long uid, String oldpwd, String newpwd);
}
