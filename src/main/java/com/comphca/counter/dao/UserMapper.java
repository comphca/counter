package com.comphca.counter.dao;

import com.comphca.counter.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByIdAndPwd(@Param("uid") Long uid, @Param("password") String password);

    void updateLoginDate(Long uid);

    int updatePwd(@Param("uid") Long uid, @Param("oldpwd") String oldpwd, @Param("newpwd") String newpwd);

    long getBalanceByUid(Long uid);

    int getUserByUid(Long uid);
}