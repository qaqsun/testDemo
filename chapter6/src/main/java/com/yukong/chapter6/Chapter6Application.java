package com.yukong.chapter6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动项
 * @author sundog
 */
@SpringBootApplication(scanBasePackages = {"com.yukong.chapter6"})
@MapperScan(basePackages = "com.yukong.chapter6.dao")
public class Chapter6Application {

    //若使用war部署到tomcat则需使用以下代码，若使用jar，则不需要。开始
    //@Override
    //protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    //    return application.sources(Chapter6Application.class);
    //}
    //若使用war部署到tomcat则需使用以下代码，若使用jar，则不需要。结束

    public static void main(String[] args) {
        SpringApplication.run(Chapter6Application.class, args);
    }
}
