package com.yukong.chapter6.controller;

import com.yukong.chapter6.config.WebConfig;
import com.yukong.chapter6.utils.FileUploadUtils;
import com.yukong.chapter6.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("file/")
@Api(tags = "文件上传接口")
@Slf4j
public class FileUploadControler {

    @Autowired
    private WebConfig webConfig;

    @PostMapping("uploadFile")
    @ApiOperation(value = "上传文件")
    @ResponseBody
    public Result upload(@RequestParam("file")MultipartFile file) throws IOException {
        log.info("地址==="+webConfig.getUploadPath());
        if (file.isEmpty()) {
            return Result.error("文件不能为空");
        }
        String fileName = FileUploadUtils.uploadText(webConfig.getUploadPath(),file);
        log.info("文件名："+fileName);
        return Result.ok("上传成功");
    }

    @PostMapping("uploadImg")
    @ApiOperation("上传图片")
    @ResponseBody
    public Result uploadImg(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("文件不能为空");
        }
        try {
            String fileName = FileUploadUtils.uploadPicture(webConfig.getAvatarPath(),file);
            log.info("图片名："+fileName);
            return Result.ok("上传成功");
        } catch (Exception e){
            log.info(e.getMessage());
            return Result.error("上传失败");
        }
    }
}
