package com.yukong.chapter6.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qinjunjie
 * @projectName SpringBoot-Study
 * @title: TestEntity
 * @description: TODO
 * @date 2019/6/1820:29
 */
@ApiModel("AgeProfileInformation")
@TableName("tb_test")
@Data
public class TestEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("名字")
    private String name;

    private String pwd;

    private Integer sex;
}
