package com.yukong.chapter6.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yukong.chapter6.dao.TestDao;
import com.yukong.chapter6.entity.TestEntity;
import com.yukong.chapter6.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qinjunjie
 * @projectName SpringBoot-Study
 * @title: TestServiceImpl
 * @description: TODO
 * @date 2019/6/229:53
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestDao, TestEntity> implements TestService {

    @Override
    public List<TestEntity> selectList() {
        LambdaQueryWrapper<TestEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TestEntity::getId,1);
        List<TestEntity> list = baseMapper.selectList(null);

        return list;
    }
}
