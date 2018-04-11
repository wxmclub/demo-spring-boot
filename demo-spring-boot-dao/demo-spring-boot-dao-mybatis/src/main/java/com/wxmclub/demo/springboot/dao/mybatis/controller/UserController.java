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
package com.wxmclub.demo.springboot.dao.mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxmclub.demo.springboot.dao.mybatis.dao.mapper.auto.UserMapper;
import com.wxmclub.demo.springboot.dao.mybatis.dao.model.auto.User;
import com.wxmclub.demo.springboot.dao.mybatis.dao.model.auto.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author wxmclub@gmail.com
 * @version 1.0
 * @date 2018-04-11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/add")
    public Result add(User user) {
        user.setId(this.genId());
        user.setCreateTime(System.currentTimeMillis());
        if (userMapper.insert(user) > 0) {
            return Result.success(user);
        } else {
            return Result.fail("add fail");
        }
    }

    private String genId() {
        String id = UUID.randomUUID().toString();
        return id.substring(0, 8) + id.substring(9, 13) + id.substring(14, 18) + id.substring(19, 23) + id.substring(24);
    }

    @RequestMapping("/update")
    public Result update(User user) {
        if (userMapper.updateByPrimaryKey(user) > 0) {
            return Result.success(null);
        } else {
            return Result.fail("update fail: id=" + user.getId());
        }
    }

    @RequestMapping("/delete")
    public Result delete(@RequestParam String id) {
        if (userMapper.deleteByPrimaryKey(id) > 0) {
            return Result.success(null);
        } else {
            return Result.fail("delete fail: id=" + id);
        }
    }

    @RequestMapping("/list")
    public Result<PageInfo<User>> delete(@RequestParam(required = false, defaultValue = "1") int page,
                                   @RequestParam(required = false, defaultValue = "10") int pageSize) {
        PageHelper.startPage(page, pageSize);
        UserCondition condition = new UserCondition();
        List<User> list = userMapper.selectByExample(condition);
        return Result.success(new PageInfo<>(list));
    }

    private static class Result<T> {
        private String code;
        private String msssage;
        private T data;

        public Result() {
        }

        public Result(String code, String message) {
            this(code, message, null);
        }

        public Result(String code, T data) {
            this(code, null, data);
        }

        public Result(String code, String message, T data) {
            this.code = code;
            this.msssage = message;
            this.data = data;
        }

        public static <T> Result<T> success(T data) {
            return new Result<>("SUCCESS", data);
        }

        public static <T> Result<T> fail(String message) {
            return new Result<>("FAIL", message);
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsssage() {
            return msssage;
        }

        public void setMsssage(String msssage) {
            this.msssage = msssage;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

}
