package com.yukong.chapter6.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yukong.chapter6.dao.SysLogDao;
import com.yukong.chapter6.entity.SysLogEntity;
import com.yukong.chapter6.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * @author qinjunjie
 * @projectName testDemo
 * @title: SysLogServiceImpl
 * @description: TODO
 * @date 2019/7/1020:14
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {
}
