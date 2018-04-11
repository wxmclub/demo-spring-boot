package com.wxmclub.demo.springboot.helloworld.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 注：修改类内容后，IDEA环境需要手动编译才能生效
 *
 * @author wxmclub@gmail.com
 * @version 1.0
 * @date 2017-12-17
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/say")
    public String say() {
        System.out.println("say: test");
        return "this is test message!";
    }

    @RequestMapping("/demo")
    public Map<String, Object> getDemo() throws ParseException {
        Map<String, Object> demo = new LinkedHashMap<>();
        demo.put("id", 1000L);
        demo.put("name", "tom");
        demo.put("sex", 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        demo.put("birthday", sdf.parse("1990-11-05"));
        demo.put("remark", "测试中文");
        demo.put("createDate", new Date());
        return demo;
    }

}
