package com.comphca.counter.controller;

import com.comphca.counter.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by comphca
 * @Date 2021/10/16 21:25
 * @Description TODO
 */
@RestController
public class Hello {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/hello2")
    public String hello2(){
        redisTemplate.opsForValue().set("glj","nm");
        return redisTemplate.opsForValue().get("glj");
    }
//    @RequestMapping("/hello")
//    public String hello(){
//        int re = userMapper.getUid(1);
//        return ""+re;
//    }
}
