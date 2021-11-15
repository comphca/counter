package com.comphca.counter.dao;

import com.comphca.counter.pojo.Order;

import java.util.List;
/*委托*/
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /*mybatis xml文件中这里的返回类型还是Order类，会自动包装为list*/
    List<Order> getOrderListByUid(Long uid);
}