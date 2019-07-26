package com.aaa.house.entity;

import java.io.Serializable;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-26 10:14
 **/
public class Customer implements Serializable {
    private Integer id;             //客户id
    private String cnumber;     //客户编号
    private String cname;       //客户姓名
    private String csex;        //客户性别
    private String cphone;      //客户电话
    private String ccard;       //客户身份证号
    private String cusername;   //客户用户名
    private String cpassword;   //客户密码
    private Integer state;          //客户状态  1：房东  2：房客
    private String cimg;        //客户头像

    public Customer(Integer id, String cnumber, String cname, String csex, String cphone, String ccard, String cusername, String cpassword, Integer state, String cimg) {
        this.id = id;
        this.cnumber = cnumber;
        this.cname = cname;
        this.csex = csex;
        this.cphone = cphone;
        this.ccard = ccard;
        this.cusername = cusername;
        this.cpassword = cpassword;
        this.state = state;
        this.cimg = cimg;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cnumber='" + cnumber + '\'' +
                ", cname='" + cname + '\'' +
                ", csex='" + csex + '\'' +
                ", cphone='" + cphone + '\'' +
                ", ccard='" + ccard + '\'' +
                ", cusername='" + cusername + '\'' +
                ", cpassword='" + cpassword + '\'' +
                ", state=" + state +
                ", cimg='" + cimg + '\'' +
                '}';
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCcard() {
        return ccard;
    }

    public void setCcard(String ccard) {
        this.ccard = ccard;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCimg() {
        return cimg;
    }

    public void setCimg(String cimg) {
        this.cimg = cimg;
    }
}
