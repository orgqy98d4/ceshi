package com.aaa.house.service;

import com.aaa.house.entity.FollowHouse;
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

    /**
     * 前台根据ID获取房屋详细信息
     */
    Map<String, Object> houseDetail(Integer id);

    /**
     * 关注房源
     */
    int followhouse(Integer houseid);

    /**
     * 判断是否已经关注
     */
    FollowHouse isFollow(Integer houseid);

    /**
     * 用户关注的房源
     */
    Page myFollowHouse();

    /**
     * 取消关注
     */
    int delFollow(Integer houseid);

    /**
     * 用户发布的房源
     */
    Page myPostedHouse();
}
