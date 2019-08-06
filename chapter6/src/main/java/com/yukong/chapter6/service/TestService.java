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
//@Deprecated 表示此方法或类不再建议使用，调用时也会出现删除线
public interface TestService extends IService<TestEntity> {

    /**
     * 测试方法
     * @return
     */
    List<TestEntity> selectList();
}
