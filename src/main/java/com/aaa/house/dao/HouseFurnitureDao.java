package com.aaa.house.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HouseFurnitureDao {
    /**
     * 获取所有家具信息
     * @return
     */
    @Select("select * from furniture")
    List<Map> queryFurnitures();
}
