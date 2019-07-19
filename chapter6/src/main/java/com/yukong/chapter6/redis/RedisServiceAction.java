package com.yukong.chapter6.redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author sundog
 * 基本redis 服务操作
 */
@Service
public class RedisServiceAction extends RedisService {

    /**
     * 数据默认有效时长 (单位分钟)
     */
    private static final long DEFAULT_TIME = 120L;

    public <T> T getEntity(String key, Class<T> clazz) {
        String data = (String) get(key);
        if (StringUtils.isEmpty(data)) {
            return null;
        }
        return JSONObject.parseObject(data, clazz);
    }

    /**
     * 获取指定数据 转换为集合
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String key, Class<T> clazz) {
        String data = (String) get(key);
        if (StringUtils.isEmpty(data)) {
            return null;
        }
        return JSONObject.parseArray(data, clazz);
    }

    /**
     * 保存数据
     *
     * @param key 键
     * @param obj 需要保存的数据
     * @return boolean
     */
    public boolean save(String key, Object obj) {
        String json = JSONObject.toJSONString(obj);
        if (obj instanceof String) {
            json = obj.toString();
        }
        return set(key, json, DEFAULT_TIME);
    }

    /**
     * 保存数据
     *
     * @param key  键
     * @param obj  需要保存的数据
     * @param time 有效时长 单位（分）
     * @return boolean
     */
    public boolean save(String key, Object obj, Long time) {
        String json = JSONObject.toJSONString(obj);
        return set(key, json, time);
    }

}