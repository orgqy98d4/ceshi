package com.aaa.house.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HouseContract {
    private Integer id;//编号
    private Integer contractid;//合同编号
    private String hname;//甲方名字
    private String hphone;//甲方电话
    private String haddress;//甲方地址
    private String hid;//甲方身份证
    private Integer agentid;//经纪人编号
    private String ename;//乙方姓名
    private String ephone;//乙方电话
    private String eaddress;//乙方地址
    private String eid;//乙方身份证
    private Integer hmeter;//房屋面积
    private String hlocation;//房屋位置
    private Integer houseid;//房屋编号
    private Integer csid;//合同状态
    private Date signdate;//合同签订日期
    private Date endate;//合同截止日期
    private Integer paytype;//付款方式（贷款、自付）
    private String money;//应付金额
    private String foregift;//应付租金（默认1000）
    private String lendmoney;//借贷金额

    public String getLendmoney() {
        return lendmoney;
    }

    public void setLendmoney(String lendmoney) {
        this.lendmoney = lendmoney;
    }

    public Date getEndate() {
        return endate;
    }

    public void setEndate(Date endate) {
        this.endate = endate;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getForegift() {
        return foregift;
    }

    public void setForegift(String foregift) {
        this.foregift = foregift;
    }

    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Integer getHmeter() {
        return hmeter;
    }

    public void setHmeter(Integer hmeter) {
        this.hmeter = hmeter;
    }

    public String getHlocation() {
        return hlocation;
    }

    public void setHlocation(String hlocation) {
        this.hlocation = hlocation;
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }
}
