package com.comphca.counter.dao;

import com.comphca.counter.pojo.Order;
import com.comphca.counter.thirdpart.order.OrderCmd;
import org.springframework.stereotype.Repository;

import java.util.List;
/*委托*/
@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /*mybatis xml文件中这里的返回类型还是Order类，会自动包装为list*/
    List<Order> getOrderListByUid(Long uid);


    //插入订单使用的对象时thirdpart中的对象OrderCmd
    int insertOrderCmd(OrderCmd orderCmd);
}