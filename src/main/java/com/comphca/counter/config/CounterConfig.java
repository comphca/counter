package com.comphca.counter.config;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Created by comphca
 * @Date 2021/10/17 15:58
 * @Description TODO
 */

@Getter
@Component
@Log4j2
public class CounterConfig {
    //配置读取yml中的值

    ///////////会员号///////////
    @Value("${counter.id}")
    private short id;

    /////////////////////UUID 相关配置////////////////////////////////
    @Value("${counter.dataCenterId}")
    private long dataCenterId;

    @Value("${counter.workerId}")
    private long workerId;
/////////////////////////////////////////////////////
}
