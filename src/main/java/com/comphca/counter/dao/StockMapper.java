package com.comphca.counter.dao;


import com.comphca.counter.pojo.Stock;

import java.util.List;
import java.util.Map;

public interface StockMapper {
    int deleteByPrimaryKey(Integer code);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer code);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);

    List<Stock> getStockListByUid(Long uid);

    List<Map<String,Object>> getAllStockInfo();
}