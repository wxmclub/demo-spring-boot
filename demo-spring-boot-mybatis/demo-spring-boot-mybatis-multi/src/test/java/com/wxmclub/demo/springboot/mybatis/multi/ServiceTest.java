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
package com.wxmclub.demo.springboot.mybatis.multi;

import com.wxmclub.demo.springboot.mybatis.dao.test.model.auto.User;
import com.wxmclub.demo.springboot.mybatis.dao.test2.model.auto.Car;
import com.wxmclub.demo.springboot.mybatis.multi.service.CarService;
import com.wxmclub.demo.springboot.mybatis.multi.service.UserService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wxmclub@gmail.com
 * @version 1.0
 * @date 2018-04-18
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;

    @Test
    public void testUser() {
        doTestUser();
    }

    private void doTestUser() {
        User user = new User();
        user.setLoginName("jack");
        user.setPassword("123");

        Assert.assertTrue(userService.add(user));

        Assert.assertEquals(user, userService.getById(user.getId()));

        Assert.assertTrue(userService.delete(user.getId()));
    }

    @Test
    public void testCar() {
        doTestCar();
    }

    private void doTestCar() {
        Car car = new Car();
        car.setName("jeep");
        car.setColor("red");

        Assert.assertTrue(carService.add(car));

        Assert.assertEquals(car, carService.getById(car.getId()));

        Assert.assertTrue(carService.delete(car.getId()));
    }

    @Test
    public void test() {
        doTestUser();

        doTestCar();
    }
}
