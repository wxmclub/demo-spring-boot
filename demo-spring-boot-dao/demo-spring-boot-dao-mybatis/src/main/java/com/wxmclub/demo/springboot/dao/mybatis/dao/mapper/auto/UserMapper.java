package com.wxmclub.demo.springboot.dao.mybatis.dao.mapper.auto;

import com.wxmclub.demo.springboot.dao.mybatis.dao.model.auto.User;
import com.wxmclub.demo.springboot.dao.mybatis.dao.model.auto.UserCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserCondition example);

    int deleteByExample(UserCondition example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCondition example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCondition example);

    int updateByExample(@Param("record") User record, @Param("example") UserCondition example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}