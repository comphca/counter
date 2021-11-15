package com.comphca.counter.controller;

import com.comphca.counter.cache.StockCache;
import com.comphca.counter.common.ServerResponse;
import com.comphca.counter.pojo.Stock;
import com.comphca.counter.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Created by comphca
 * @Date 2021/11/13 13:05
 * @Description TODO
 */
@RestController
@Log4j2
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private StockCache stockCache;
    @RequestMapping("/balance")
    public ServerResponse getBalance(Long uid){
        return userService.getBalanceByUid(uid);
    }

    @RequestMapping("/code")
    public ServerResponse sotckQuery(@RequestParam String key) {
        return stockCache.getStock(key);

    }
}
