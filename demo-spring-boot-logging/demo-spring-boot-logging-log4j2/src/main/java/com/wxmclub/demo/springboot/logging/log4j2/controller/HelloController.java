package com.wxmclub.demo.springboot.logging.log4j2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wxmclub@gmail.com
 * @version 1.0
 * @date 2017-12-17
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/say")
    public String say() {
        log.debug("say: test");
        log.info("say: test");
        log.warn("say: test");
        log.error("say: test");
        return "this is test message!";
    }

    @RequestMapping("/demo")
    public Map<String, Object> getDemo() throws ParseException {
        Map<String, Object> demo = new LinkedHashMap<>();
        demo.put("id", 1002L);
        demo.put("name", "jack2");
        demo.put("sex", 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        demo.put("birthday", sdf.parse("1990-10-05"));
        demo.put("remark", "测试中文1234");
        demo.put("createDate", new Date());
        log.debug(demo.toString());
        log.info(demo.toString());
        return demo;
    }

}
