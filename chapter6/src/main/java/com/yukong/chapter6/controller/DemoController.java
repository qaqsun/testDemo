package com.yukong.chapter6.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qinjunjie
 * @projectName SpringBoot-Study
 * @title: DemoController
 * @description: TODO
 * @date 2019/6/1811:05
 */

@RestController
@RequestMapping("/demo/")
@Api(tags = "测试接口")
public class DemoController {

    @Value("${demo-data.name}")
    public String name;

    @Autowired
    private DataSource dataSource;

    @GetMapping("demo")
    @ApiOperation("接口")
    public Object demo() throws Exception{
        Connection connection = dataSource.getConnection();
        PreparedStatement pre = connection.prepareStatement("select * from tb_test");
        ResultSet resultSet = pre.executeQuery();
        List<Map<String,Object>> list = new ArrayList<>();
        while (resultSet.next()){
            Map<String,Object> map = new HashMap<>();
            map.put("id",resultSet.getObject("id"));
            map.put("name",resultSet.getObject("name"));
            list.add(map);
        }
        if (resultSet != null)
            resultSet.close();
        if (pre != null)
            pre.close();
        if (connection != null)
            connection.close();
        return list;
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        List<String> b = new ArrayList<>();
        b.add("1");
        b.add("5");
        b.add("6");
        b.add("7");
        a.retainAll(b);
        System.out.println(a);
    }
}
