package com.aaa.house.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 86187 杨金瑞
 * Date: 2019/8/7
 * Time: 10:29
 **/
public class LendAudit {

    private Integer id;//还款的是否还完
    private String audit;//是否还完

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    @Override
    public String toString() {
        return "LendAudit{" +
                "id=" + id +
                ", audit='" + audit + '\'' +
                '}';
    }
}
