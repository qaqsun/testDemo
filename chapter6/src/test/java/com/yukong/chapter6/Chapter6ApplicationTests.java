package com.yukong.chapter6;

import com.yukong.chapter6.entity.TestEntity;
import com.yukong.chapter6.entity.User;
import com.yukong.chapter6.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter6ApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TestService testService;

    @Test
    public void redisTest() {
         //redis存储数据
        String key = "name";
        redisTemplate.opsForValue().set(key, "yukong");
         //获取数据
        String value = (String) redisTemplate.opsForValue().get(key);
        System.out.println("获取缓存中key为" + key + "的值为：" + value);

        User user = new User();
        user.setUsername("yukong");
        user.setSex(18);
        user.setId(1L);
        String userKey = "yukong";
        redisTemplate.opsForValue().set(userKey, user);
        User newUser = (User) redisTemplate.opsForValue().get(userKey);
        System.out.println("获取缓存中key为" + userKey + "的值为：" + newUser);

        TestEntity entity = new TestEntity();
        entity.setName("测试名字");
        entity.setPwd("123456");
        entity.setSex(1);
        String testName = "demo";
        redisTemplate.opsForValue().set(testName,entity);
        TestEntity newTset = (TestEntity) redisTemplate.opsForValue().get(testName);
        System.out.println("取出的值key: "+testName+" value: "+newTset);
    }

    @Test
    public void DataTable() throws Exception{
        Connection connection = dataSource.getConnection();
        PreparedStatement pre = connection.prepareStatement("select * from tb_test ");
        ResultSet resultSet = pre.executeQuery();
        List<TestEntity> list = new ArrayList<>();
        while (resultSet.next()){
            TestEntity testEntity = new TestEntity();
            testEntity.setId((Long) resultSet.getObject("id"));
            testEntity.setName(resultSet.getObject("name").toString());
            testEntity.setPwd(resultSet.getObject("pwd").toString());
            testEntity.setSex((Integer) resultSet.getObject("sex"));
            list.add(testEntity);
        }
        if (resultSet != null)
            resultSet.close();
        if (pre != null)
            pre.close();
        if (connection != null)
            connection.close();

        String testKey = "dataTable";
        redisTemplate.opsForValue().set(testKey,list);
        Object a = redisTemplate.opsForValue().get(testKey);
        System.out.println("key："+testKey+"value："+a);
    }

    @Test
    public void selectList(){
        testService.selectList();
        //System.out.println("测试");
    }

}
