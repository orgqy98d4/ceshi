package com.aaa.house.entity;

/**
 * @program: house_rentd4
 * @description:关注的房源
 * @author: WGY
 * @create: 2019-08-06 15:42
 **/
public class FollowHouse {
    private Integer id;
    private Integer cid;
    private Integer houseid;

    @Override
    public String toString() {
        return "FollowHouse{" +
                "id=" + id +
                ", cid=" + cid +
                ", houseid=" + houseid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }
}
