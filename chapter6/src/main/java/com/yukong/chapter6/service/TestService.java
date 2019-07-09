package com.yukong.chapter6.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yukong.chapter6.entity.TestEntity;

import java.util.List;

/**
 * @author qinjunjie
 * @projectName SpringBoot-Study
 * @title: TsetService
 * @description: TODO
 * @date 2019/6/229:52
 */
public interface TestService extends IService<TestEntity> {

    List<TestEntity> selectList();
}
