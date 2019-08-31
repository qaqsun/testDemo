package com.yukong.chapter6;

import com.yukong.chapter6.config.WebConfig;
import com.yukong.chapter6.entity.SysMenuEntity;
import com.yukong.chapter6.redis.RedisServiceAction;
import com.yukong.chapter6.service.SysMenuService;
import com.yukong.chapter6.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Chapter6ApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TestService testService;

    @Autowired
    private RedisServiceAction redisServiceAction;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private WebConfig webConfig;

    @Test
    public void redisTest() {
         //redis存储数据

        /*User user = new User();
        user.setUsername("yukong");
        user.setSex(18);
        user.setId(1L);
        String userKey = "yukong";
        redisServiceAction.save(userKey,user,2L);
        user = redisServiceAction.getEntity(userKey,User.class);
        System.out.println("获取缓存中key为" + userKey + "的值为：" + user.toString());*/
    }

    /*@Test
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

        Long count = list.parallelStream().filter(x->x.getId() >0).count();
        System.out.println(count);

        //String testKey = "dataTable";
        //redisServiceAction.save(testKey,list);
        //List<TestEntity> entityList = redisServiceAction.getList(testKey,TestEntity.class);
        //
        //System.out.println("key："+testKey+"value："+entityList.toString());
    }*/

    @Test
    public void selectList(){
        /*List<TestEntity> list = testService.selectList();
        System.out.println(Result.ok(list));*/
    }

    @Test
    public void stream(){
        List<SysMenuEntity> list = sysMenuService.list();
        // 过滤 parentId == -1
        /*list.stream().filter(x->x.getParentId() != -1).forEach(x->{
            System.out.println("父级id："+x.getParentId());
        });*/
        // 排序 DESC
        /*list.stream().sorted(Comparator.comparing(SysMenuEntity::getMenuId).reversed()).forEach(x->{
            System.out.println("名称: "+x.getName()+"父级id："+x.getParentId()+"排序："+x.getMenuId());
        });*/
        // 排序 ASC
        /*list.stream().filter(s->s.getParentId().equals(6100)).sorted(Comparator.comparing(SysMenuEntity::getMenuId)).forEach(x->{
            System.out.println("名称: "+x.getName()+"父级id："+x.getParentId()+"排序："+x.getMenuId());
        });*/
        // 在map内转换 给特定数据赋值
        /*list.stream().sorted(Comparator.comparing(SysMenuEntity::getMenuId)).map(sysMenu->{
            SysMenuEntity entity = new SysMenuEntity();
            entity.setName(sysMenu.getName());
            entity.setSort(sysMenu.getMenuId());
            if (sysMenu.getMenuId().equals(6101)){
                entity.setPermission("KKP");
            }
            return entity;
        }).collect(Collectors.toList()).forEach(System.out::println);*/
        // 过滤
        /*list.stream().filter(s->s.getParentId().equals(1200)).filter(s->s.getType().equals("1")).forEach(System.out::println);

        for (SysMenuEntity sysMenuEntity:list){
            if(!sysMenuEntity.getParentId().equals(1200)){
                continue;
            }
            if(!sysMenuEntity.getType().equals("1")){
                continue;
            }
            System.out.println(sysMenuEntity);
        }*/
        // 插入数据
        /*List<SysMenuEntity> entities = new ArrayList<>();
        for (int i =1000;i<=100000;i++){
            SysMenuEntity entity = new SysMenuEntity();
            entity.setSort(i+1);
            entity.setParentId(1000+i);
            entity.setName("测试菜单"+i);
            entities.add(entity);
        }
        sysMenuService.saveBatch(entities);*/
        // 时间对比
        /*long start = System.currentTimeMillis();
        list.forEach(System.out::println);
        long one = System.currentTimeMillis();
        for (SysMenuEntity sysMenuEntity:list){
            System.out.println(sysMenuEntity);
        }
        long end = System.currentTimeMillis();
        long oneTime = one - start;
        long twoTime = end - one;
        //long类型时间差转为double类型时间差，单位毫秒
        System.out.println("one耗费时间："+oneTime);
        System.out.println("two耗费时间："+twoTime);
        System.out.println("大小"+list.size());*/
    }

    @Test
    public void fileTest(){
//        System.out.println(webConfig.getAvatarPath());
    }

}
