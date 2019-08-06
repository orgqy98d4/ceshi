package com.aaa.house.service;

import com.aaa.house.entity.House;
import com.aaa.house.entity.HouseFurniture;
import com.aaa.house.util.Page;

import java.util.List;
import java.util.Map;

public interface HouseService {
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

    /**
     * 前台获取全部已发布的房屋列表
     */
    Page houseList(House house, int current, int pageSize);
}
