package com.yukong.chapter6.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yukong.chapter6.dao.SysMenuDao;
import com.yukong.chapter6.entity.SysMenuEntity;
import com.yukong.chapter6.service.SysMenuService;
import org.springframework.stereotype.Service;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {
}
