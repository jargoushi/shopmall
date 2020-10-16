package com.wjy.domain;

import java.util.Map;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 17:27
 * @Description:
 */
public class ResponseResult {

    //响应码
    private int code;

    //打印信息
    private String msg;

    private Map<String,Object> info;

    public ResponseResult(int code, Map<String, Object> info) {
        this.code = code;
        this.info = info;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(int code, String msg, Map<String, Object> info) {
        this.code = code;
        this.msg = msg;
        this.info = info;
    }

    public static ResponseResult success(Map<String, Object> info) {
        return new ResponseResult(100, info);
    }

    public static ResponseResult success(String msg, Map<String, Object> info) {
        return new ResponseResult(200, msg, info);
    }

    public static ResponseResult fail(String msg) {
        return new ResponseResult(500, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", info=" + info +
                '}';
    }
}
