package com.yukong.chapter6;

import com.yukong.chapter6.entity.TestEntity;
import com.yukong.chapter6.entity.User;
import com.yukong.chapter6.redis.RedisServiceAction;
import com.yukong.chapter6.service.TestService;
import com.yukong.chapter6.until.Result;
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
    private DataSource dataSource;

    @Autowired
    private TestService testService;

    @Autowired
    private RedisServiceAction redisServiceAction;

    @Test
    public void redisTest() {
         //redis存储数据

        User user = new User();
        user.setUsername("yukong");
        user.setSex(18);
        user.setId(1L);
        String userKey = "yukong";
        redisServiceAction.save(userKey,user,2L);
        user = redisServiceAction.getEntity(userKey,User.class);
        System.out.println("获取缓存中key为" + userKey + "的值为：" + user.toString());
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
        redisServiceAction.save(testKey,list);
        List<TestEntity> entityList = redisServiceAction.getList(testKey,TestEntity.class);

        System.out.println("key："+testKey+"value："+entityList.toString());
    }

    @Test
    public void selectList(){
        List<TestEntity> list = testService.selectList();
        System.out.println(Result.ok(list));
    }

}
