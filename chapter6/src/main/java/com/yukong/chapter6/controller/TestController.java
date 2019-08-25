package com.yukong.chapter6.controller;

import com.yukong.chapter6.annotation.Log;
import com.yukong.chapter6.service.SysMenuService;
import com.yukong.chapter6.untils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/")
@Api(tags = "测试接口")
public class TestController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("info")
    @ApiOperation("获取详情")
    @Log(value = "获取菜单详情",mark = "这是备注")
    public Result info(Long id){
        return Result.ok(sysMenuService.getById(id));
    }
}
