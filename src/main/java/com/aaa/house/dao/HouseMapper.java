package com.aaa.house.dao;

import com.aaa.house.entity.House;
import com.aaa.house.entity.HouseFurniture;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HouseMapper {
    int queryHouseCount(Map map);

    List<Map> queryHouses(Map map);

    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    /**
     * 保存家具信息
     * @param houseFurniture
     * @return
     */
    int saveFurniture(HouseFurniture houseFurniture);
}