package com.yukong.chapter6.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_log")
public class SysLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("方法名")
    private String methodName;

    @ApiModelProperty("创建人")
    private Long createBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("ip地址")
    private String ip;

    @ApiModelProperty("用户操作")
    private String operation;

    @ApiModelProperty("请求参数")
    private String params;

    @ApiModelProperty("执行时间")
    private Long time;
}
