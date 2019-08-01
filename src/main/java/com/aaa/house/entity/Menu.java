package com.aaa.house.entity;

public class Menu {
    private Integer mid;

    private String mname;

    private String mdesc;

//    private int pid;
//
//    private String url;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc == null ? null : mdesc.trim();
    }
}