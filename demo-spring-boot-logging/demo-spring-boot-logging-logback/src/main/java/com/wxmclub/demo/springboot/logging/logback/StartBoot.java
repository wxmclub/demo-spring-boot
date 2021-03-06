package com.wxmclub.demo.springboot.logging.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication same as @Configuration @EnableAutoConfiguration @ComponentScan
 *
 * @author wxmclub@gmail.com
 * @version 1.0
 * @date 2017-12-17
 */
@SpringBootApplication(scanBasePackages = {"com.wxmclub.demo.springboot.logging.service"})
public class StartBoot {

    public static void main(String[] args) {
        SpringApplication.run(StartBoot.class, args);
    }

}
