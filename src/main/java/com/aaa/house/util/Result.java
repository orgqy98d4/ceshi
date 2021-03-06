package com.aaa.house.util;

/**
 * @program: house_rentd4
 * @description: 交互实体类
 * @author: WGY
 * @create: 2019-07-31 16:34
 **/
public class Result {

    private Integer code;
    private String msg;
    private Object object;
    private Integer count;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Result() {
    }

    public Result(Integer code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }
    public Result(Integer code, String msg, Object object,Integer count) {
        this.code = code;
        this.msg = msg;
        this.object = object;
        this.count=count;
    }

}
