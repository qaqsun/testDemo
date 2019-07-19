package com.yukong.chapter6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.yukong.chapter6")
@MapperScan(basePackages = "com.yukong.chapter6.dao")
public class Chapter6Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter6Application.class, args);
    }
}
