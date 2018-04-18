/*
MIT License

Copyright (c) 2018 wxmclub@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.wxmclub.demo.springboot.mybatis.multiaop.service;

import com.wxmclub.demo.springboot.mybatis.dao.test2.mapper.auto.CarMapper;
import com.wxmclub.demo.springboot.mybatis.dao.test2.model.auto.Car;
import com.wxmclub.demo.springboot.mybatis.multiaop.config.DS;
import com.wxmclub.demo.springboot.mybatis.multiaop.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wxmclub@gmail.com
 * @version 1.0
 * @date 2018-04-17
 */
@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    @DS("test2")
    public boolean add(Car car) {
        car.setId(UUIDUtils.genId());
        car.setCreateTime(System.currentTimeMillis());
        return carMapper.insert(car) > 0;
    }

    @DS("test2")
    public Car getById(String id) {
        return carMapper.selectByPrimaryKey(id);
    }

    @DS("test2")
    public boolean delete(String id) {
        return carMapper.deleteByPrimaryKey(id) > 0;
    }

}
