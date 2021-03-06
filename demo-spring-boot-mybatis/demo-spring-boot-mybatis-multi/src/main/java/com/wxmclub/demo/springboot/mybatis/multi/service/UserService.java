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
package com.wxmclub.demo.springboot.mybatis.multi.service;

import com.wxmclub.demo.springboot.mybatis.dao.test.mapper.auto.UserMapper;
import com.wxmclub.demo.springboot.mybatis.dao.test.mapper.self.UserSelfMapper;
import com.wxmclub.demo.springboot.mybatis.dao.test.model.auto.User;
import com.wxmclub.demo.springboot.mybatis.multi.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wxmclub@gmail.com
 * @version 1.0
 * @date 2018-04-11
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserSelfMapper userSelfMapper;

    public boolean add(User user) {
        user.setId(UUIDUtils.genId());
        user.setCreateTime(System.currentTimeMillis());
        return userMapper.insert(user) > 0;
    }

    public User getById(String id) {
        return userSelfMapper.findById(id);
    }

    public boolean delete(String id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

}
