package com.aaa.house.entity;

import org.springframework.stereotype.Component;

@Component
public class HouseFurniture {
    private Integer id;
    private Integer houseid;
    private Integer furnitureid;

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

    public Integer getFurnitureid() {
        return furnitureid;
    }

    public void setFurnitureid(Integer furnitureid) {
        this.furnitureid = furnitureid;
    }
}
