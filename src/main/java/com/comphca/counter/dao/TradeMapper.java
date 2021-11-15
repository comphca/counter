package com.comphca.counter.dao;


import com.comphca.counter.pojo.Trade;

import java.util.List;
/*成交*/
public interface TradeMapper {
    int insert(Trade record);

    int insertSelective(Trade record);


    List<Trade> getTradeListByUid(Long uid);
}