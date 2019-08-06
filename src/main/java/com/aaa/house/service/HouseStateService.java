package com.aaa.house.service;

import com.aaa.house.entity.House;
import com.aaa.house.entity.HouseContract;

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

    /**
     * 向房东表中添加一条信息
     * @param house
     * @return
     */
    int addHost(House house);
    /**
     * 根据房东姓名获取该房东对应的编号id
     * @param cname
     * @return
     */
    int getIdByCname(String cname);
    /**
     * 获取到房屋编号后为相应的房屋设置房东编号
     * @param id
     * @param houseid
     * @return
     */
    int setHostId(Integer id,Integer houseid);

    /**
     * 根据编号，书写驳回理由
     * @param house
     * @return
     */
    int setRejectReason(House house);

    /**
     * 查询出所有已审核的房源
     * @return
     */
    List<Map> queryChecked();

    /**
     * 修改待审核的房源状态为已发布
     * @return
     */
    int updateChecked(int houseid);

    /**
     * 查询出所有已发布的房源
     * @return
     */
    List<Map> queryReleased();
    /**
     * 添加合同信息
     * @param houseContract
     * @return
     */
    int addContract(HouseContract houseContract);
}
