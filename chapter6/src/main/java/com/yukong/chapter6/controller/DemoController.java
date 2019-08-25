package com.yukong.chapter6.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * @author qinjunjie
 * @projectName SpringBoot-Study
 * @title: DemoController
 * @description: TODO
 * @date 2019/6/1811:05
 */

@RestController
@RequestMapping("/demo/")
@Api(tags = "demo接口")
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

    public static void main(String[] args) throws IOException{

        //List<String> a = new ArrayList<>();
        //a.add("1");
        //a.add("2");
        //a.add("3");
        //a.add("4");
        //List<String> b = new ArrayList<>();
        //b.add("1");
        //b.add("5");
        //b.add("6");
        //b.add("7");
        //// 得到相同的
        //a.retainAll(b);
        //System.out.println(a);

        /**
         * Scanner 用法
         */
        //String mm = "NMSL";
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("输入:");
        //while (!scanner.hasNext(mm)){
        //    String str = scanner.next();
        //    System.out.println("输入的值"+str);
        //}
        //scanner.close();
        //System.out.println("关闭输入");

        /**
         * IO流
         */
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\text.txt"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\text1.txt"));
        // 一次性读取多少字节
        byte[] bytes = new byte[2048];
        int n =-1;
        while ((n = in.read(bytes,0,bytes.length)) != -1){
            // 转换成字符串
            String str = new String(bytes,0,n,"UTF-8");
            System.out.println(str);
            out.write(bytes,0,n);
        }
        // 清除缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
    }
}
