package com.aaa.house.util;

/**
 * @program: house_rentd4
 * @description:分页实体类
 * @author: WGY
 * @create: 2019-08-05 18:22
 **/
public class Page {
    private Object object;
    private Integer total;

    public Page(Object object, Integer total) {
        this.object = object;
        this.total = total;
    }

    public Page() {
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
