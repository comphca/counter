package com.comphca.counter.dao;

import com.comphca.counter.pojo.Posi;

import java.util.List;
/*持仓*/
public interface PosiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Posi record);

    int insertSelective(Posi record);

    Posi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Posi record);

    int updateByPrimaryKey(Posi record);

    /*mybatis xml文件中这里的返回类型还是Order类，会自动包装为list*/
    List<Posi> getPosiListByUid(Long uid);
}