package com.yukong.chapter6.until;

import com.alibaba.fastjson.JSONObject;
import com.yukong.chapter6.common.RequestStatus;
import lombok.Data;

/**
 * @author qinjunjie
 * @projectName testDemo
 * @title: Result
 * @description: 返回数据
 * @date 2019/7/1010:42
 */

@Data
public class Result implements RequestStatus {

    private Integer code;

    private String msg;

    private Object data;

    /**
     * 无数据返回
     * @return
     */
    public static Result ok() {
        Result result = new Result();
        result.code = SUCCESS_CODE;
        result.msg = null;
        result.data = null;
        return result;
    }

    /**
     * 返回成功消息
     * @param msg 消息
     * @return
     */
    public static Result ok(String msg){
        return Result.ok().setMsg(msg);
    }

    /**
     * 返回成功数据
     * @param data 需返回的数据
     * @return
     */
    public static Result ok(Object data){
        return Result.ok().setData(data);
    }

    /**
     * 返回错误参数
     * @param msg 错误信息
     * @return
     */
    public static Result error(String msg){
        Result result = new Result();
        result.code = FAILURE_CODE;
        result.msg = msg;
        result.data = null;
        return result;
    }

    /**
     * 自定义错误返回
     * @param code 返回code
     * @param msg
     * @return
     */
    public static Result error(Integer code,String msg){
        return Result.error(msg).setCode(code);
    }

    private Result setMsg(String msg){
        this.msg = msg;
        return this;
    }

    private Result setCode(Integer code){
        this.code = code;
        return this;
    }

    private Result setData(Object data){
        this.data = data;
        return this;
    }

    public String toJson(){
        return JSONObject.toJSONString(this);
    }

}
