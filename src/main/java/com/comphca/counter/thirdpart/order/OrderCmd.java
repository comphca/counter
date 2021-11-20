package com.comphca.counter.thirdpart.order;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Created by comphca
 * @Date 2021/11/18 21:42
 * @Description TODO
 */
@Builder
@ToString
@Data
public class OrderCmd implements Serializable {
    public CmdType type;

    public long timestamp;

    /**
     * 会员ID,标志从那家券商或者那家机构过来的
     */
    final public short mid;

    /**
     * 用户ID
     */
    final public long uid;

    /**
     * 代码
     */
    final public int code;

    /**
     * 方向
     */
    final public OrderDirection direction;

    /**
     * 价格
     */
    final public long price;

    /**
     * 量
     */
    final public long volume;

    /**
     * 委托类型
     * 1.LIMIT
     */
    final public OrderType orderType;

    /**
     * 委托编号
     */
    public long oid;
}
