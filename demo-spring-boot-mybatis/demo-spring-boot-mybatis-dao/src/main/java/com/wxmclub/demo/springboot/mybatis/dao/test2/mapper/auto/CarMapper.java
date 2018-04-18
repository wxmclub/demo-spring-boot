package com.wxmclub.demo.springboot.mybatis.dao.test2.mapper.auto;

import com.wxmclub.demo.springboot.mybatis.dao.test2.model.auto.Car;
import com.wxmclub.demo.springboot.mybatis.dao.test2.model.auto.CarCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {
    long countByExample(CarCondition example);

    int deleteByExample(CarCondition example);

    int deleteByPrimaryKey(String id);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExample(CarCondition example);

    Car selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarCondition example);

    int updateByExample(@Param("record") Car record, @Param("example") CarCondition example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}