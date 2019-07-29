package com.aaa.house.entity;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-29 10:01
 **/
public class Custype {
    private Integer ctype;       //客户类型id
    private String ctname;      //客户所有类型

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

}
