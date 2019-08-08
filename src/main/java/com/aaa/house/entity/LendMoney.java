package com.aaa.house.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: 86187 杨金瑞
 * Date: 2019/8/7
 * Time: 10:24
 **/
public class LendMoney {

    private Integer id;//借贷表主键
    private Integer jdid;//借贷编号
    private String jdname;//借贷人姓名
    private Date cdDate;//借贷日期
    private Date repaymentDate;//还款日期
    private String jdmoney;//借贷金额
    private String jdinterest;//借贷的利率
    private String sum;//总金额
    private String headPic;//身份证照片
    private String headPicName;//上传身份证
    private Integer auditid;//是否还完借贷
    private Integer conid;//根据合同填写借贷的内容

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getJdname() {
        return jdname;
    }

    public void setJdname(String jdname) {
        this.jdname = jdname;
    }

    public Date getCdDate() {
        return cdDate;
    }

    public void setCdDate(Date cdDate) {
        this.cdDate = cdDate;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getJdmoney() {
        return jdmoney;
    }

    public void setJdmoney(String jdmoney) {
        this.jdmoney = jdmoney;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
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

    public Integer getAuditid() {
        return auditid;
    }

    public void setAuditid(Integer auditid) {
        this.auditid = auditid;
    }

    public Integer getConid() {
        return conid;
    }

    public void setConid(Integer conid) {
        this.conid = conid;
    }

    public Integer getJdid() {
        return jdid;
    }

    public void setJdid(Integer jdid) {
        this.jdid = jdid;
    }

    public String getJdinterest() {
        return jdinterest;
    }

    public void setJdinterest(String jdinterest) {
        this.jdinterest = jdinterest;
    }
}
