package com.yukong.chapter6.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件路径配置
 * @author sundog
 */

@Component
@ConfigurationProperties(prefix = "filepath")
public class WebConfig {
    /**
     * 文件路径
     */
    private String profile;


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * 获取上传头像路径
     */
    public String getAvatarPath() {
        return profile + "avatar/";
    }

    /**
     * 获取下载路径
     */
    public String getDownloadPath() {
        return profile + "download/";
    }

    /**
     * 获取上传路径
     */
    public String getUploadPath() {
        return profile + "upload/";
    }
}
