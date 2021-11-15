package com.comphca.counter;

import com.comphca.counter.config.CounterConfig;
import com.comphca.counter.dao.StockMapper;
import com.comphca.counter.utils.myuuid;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

//前后端分离存在跨域的问题从8081端口发送消息到8080端口，这里使用过滤器解决
@SpringBootApplication
@MapperScan(value = "com.comphca.counter.dao")
public class CounterApplication {


    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }

    @Autowired
    private CounterConfig counterConfig;

    @PostConstruct
    private void init(){
        myuuid.getInstance().init(counterConfig.getDataCenterId(),
                counterConfig.getWorkerId());

    }

}
