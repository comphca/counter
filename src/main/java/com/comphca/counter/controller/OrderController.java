package com.comphca.counter.controller;

import com.comphca.counter.cache.StockCache;
import com.comphca.counter.common.ServerResponse;
import com.comphca.counter.pojo.Stock;
import com.comphca.counter.service.OrderService;
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
    @Autowired
    private OrderService orderService;
    @RequestMapping("/balance")
    public ServerResponse getBalance(Long uid){
        return userService.getBalanceByUid(uid);
    }

    //终端输入框输入股票代码、简称的时候调用的接口
    @RequestMapping("/code")
    public ServerResponse sotckQuery(@RequestParam String key) {
        return stockCache.getStock(key);

    }

    //不建议OrderCmd对象作为http接口的入参传入，由于OrderCmd对象和上层http接口没有关系，不适合暴露在上层的接口中，OrderCmd属于service和dao和交易网关交互的对象
    @RequestMapping("/sendorder")
    public ServerResponse order(@RequestParam int uid, @RequestParam short type,
                                @RequestParam long timestamp,
                                @RequestParam int code,
                                @RequestParam byte direction,
                                @RequestParam long price,
                                @RequestParam long volume,
                                @RequestParam byte ordertype){
        log.info("收到委托");
        return orderService.saveOrder(uid,type,timestamp,code,direction,price,volume,ordertype);
    }
}
