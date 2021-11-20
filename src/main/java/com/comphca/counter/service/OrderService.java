package com.comphca.counter.service;

import com.comphca.counter.common.ServerResponse;

/**
 * @Created by comphca
 * @Date 2021/11/13 13:00
 * @Description TODO
 */
public interface OrderService {
    ServerResponse saveOrder(long uid, short type, long timestamp,
                             int code, byte direction, long price,
                             long volume, byte ordertype);

}
