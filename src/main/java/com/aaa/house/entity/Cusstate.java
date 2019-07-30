package com.aaa.house.entity;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-29 10:01
 **/
public class Cusstate {
    private Integer state;       //客户状态id
    private String csname;      //客户所有状态

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String cdname) {
        this.csname = cdname;
    }
}
