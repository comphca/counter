package com.comphca.counter.service.Impl;

import com.comphca.counter.common.ServerResponse;
import com.comphca.counter.config.CounterConfig;
import com.comphca.counter.dao.OrderMapper;
import com.comphca.counter.pojo.Order;
import com.comphca.counter.service.OrderService;
import com.comphca.counter.thirdpart.order.CmdType;
import com.comphca.counter.thirdpart.order.OrderCmd;
import com.comphca.counter.thirdpart.order.OrderDirection;
import com.comphca.counter.thirdpart.order.OrderType;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by comphca
 * @Date 2021/11/13 13:23
 * @Description TODO
 */
@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
    //注入配置类方便读取配置类中的变量值
    @Autowired
    private CounterConfig counterConfig;

    @Autowired
    private OrderMapper orderMapper;
    @Override
    @Transactional
    public ServerResponse saveOrder(long uid, short type, long timestamp, int code, byte direction, long price, long volume, byte ordertype) {
        //流式编程能够快速建一个自己想要的对象
        final OrderCmd orderCmd = OrderCmd.builder()
                .type(CmdType.of(type))
                .timestamp(timestamp)
                .mid(counterConfig.getId())
                .uid(uid)
                .code(code)
                .direction(OrderDirection.of(direction))
                .price(price)
                .volume(volume)
                .orderType(OrderType.of(ordertype))
                .build();


        int oid = orderMapper.insertOrderCmd(orderCmd);
        if (oid < 0){
            return ServerResponse.createByErrorMessage("保存数据到柜台失败");
        }else {
            //TODO 发送网关
            log.info(orderCmd);
        }

        return ServerResponse.createBySuccess("保存数据到柜台成功");
    }
}
