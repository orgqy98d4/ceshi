package com.aaa.house.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class House {
    private Integer id;//房屋信息表

    private Integer houseid;//房屋编号

    private Integer landlord;//房东编号

    private String htitle;//房屋简述

    private String hadr;//房屋地址

    private Integer hrent;//房屋租金

    private Integer state;//房屋状态

    private String headPic;//房屋图片

    private String headPicName;//房屋图片

    private Integer hfloor;//房屋楼层

    private String harea;//房屋面积

    private String orientation;//房屋朝向

    private Date releasedate;//房屋发布日期

    private String newstime;//房屋发布日期至今

    private String hdesc;//房屋格局

    private Integer agentid;//经纪人编号

    private Integer tenantid;//租客编号

    private String cimg;//合同图片

    private String examine;//审核状态

    private Integer stateid; //房屋状态编号
    private String name;//房屋状态
    private String leaseWay;//出租方式，如：合租、单租
    private String cname;//房东姓名
    private String cphone;//房东电话
    private String rejectReason;//驳回理由

    private List<String> installation;//配套设施

    public List<String> getInstallation() {
        return installation;
    }

    public void setInstallation(List<String> installation) {
        this.installation = installation;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getLeaseWay() {
        return leaseWay;
    }

    public void setLeaseWay(String leaseWay) {
        this.leaseWay = leaseWay;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public Integer getLandlord() {
        return landlord;
    }

    public void setLandlord(Integer landlord) {
        this.landlord = landlord;
    }

    public String getHtitle() {
        return htitle;
    }

    public void setHtitle(String htitle) {
        this.htitle = htitle == null ? null : htitle.trim();
    }

    public String getHadr() {
        return hadr;
    }


    public void setHadr(String hadr) {
        this.hadr = hadr    == null ? null : hadr.trim();
    }

    public Integer getHrent() {
        return hrent;
    }

    public void setHrent(Integer hrent) {
        this.hrent = hrent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getHeadPicName() {
        return headPicName;
    }

    public void setHeadPicName(String headPicName) {
        this.headPicName = headPicName;
    }

    public Integer getHfloor() {
        return hfloor;
    }

    public void setHfloor(Integer hfloor) {
        this.hfloor = hfloor;
    }

    public String getHarea() {
        return harea;
    }

    public void setHarea(String harea) {
        this.harea = harea == null ? null : harea.trim();
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation == null ? null : orientation.trim();
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public String getHdesc() {
        return hdesc;
    }

    public void setHdesc(String hdesc) {
        this.hdesc = hdesc == null ? null : hdesc.trim();
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public Integer getTenantid() {
        return tenantid;
    }

    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }

    public String getCimg() {
        return cimg;
    }

    public void setCimg(String cimg) {
        this.cimg = cimg == null ? null : cimg.trim();
    }

    public String getExamine() {
        return examine;
    }

    public void setExamine(String examine) {
        this.examine = examine == null ? null : examine.trim();
    }
}