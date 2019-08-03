package com.aaa.house.service;

import java.util.List;
import java.util.Map;

public interface HouseStateService {
    /**
     * 获取状态集合列表
     * @return
     */
    List<Map> queryStates();

    /**
     * 只查询出一条状态，即待审核，id为2
     * @return
     */
    List<Map> queryState2();

    /**
     * 获取经纪人列表
     * @return
     */
    List<Map> queryAgents();

    /**
     * 查询出所有待审核的房源
     * @return
     */
    List<Map> queryUnchecked();

    /**
     * 修改待审核的房源状态为已审核
     * @return
     */
    int updateUnchecked(int houseid);

    /**
     * 查询出所有已出租的房源
     * @return
     */
    List<Map> queryRented();
}
