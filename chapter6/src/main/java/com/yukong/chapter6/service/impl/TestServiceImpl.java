package com.yukong.chapter6.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yukong.chapter6.dao.TestDao;
import com.yukong.chapter6.entity.TestEntity;
import com.yukong.chapter6.service.TestService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
//@RequiredArgsConstructor
public class TestServiceImpl extends ServiceImpl<TestDao, TestEntity> implements TestService {

    //private final TestService testService;

    @Autowired
    private TestService testService;

    @Override
    public List<TestEntity> selectList() {
        LambdaQueryWrapper<TestEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TestEntity::getId,1);
        List<TestEntity> list = testService.list();

        return list;
    }
}
