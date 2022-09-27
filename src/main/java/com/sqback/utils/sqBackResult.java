package com.sqback.utils;

import lombok.Data;

/**
 * 成绩查询系统自定义响应结构
 */
@Data
public class sqBackResult {

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;

    public static sqBackResult build(Integer code, String message, Object data) {

        return new sqBackResult(code, message, data);
    }

    public static sqBackResult ok(Object data) {

        return new sqBackResult(data);
    }

    public static sqBackResult ok() {

        return new sqBackResult(null);
    }

    public sqBackResult() {

    }

    public static sqBackResult build(Integer code, String message) {
        return new sqBackResult(code, message, null);
    }

    public sqBackResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public sqBackResult(Object data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
