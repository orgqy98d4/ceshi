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
    List<Map> queryUnchecked(Map map);
    //查询出所有待审核的房源数量
    int uncheckedCount(Map map);

    /**
     * 修改待审核的房源状态为已审核
     * @return
     */
    int updateUnchecked(int houseid);

    /**
     * 查询出所有已出租的房源
     * @return
     */
    List<Map> queryRented(Map map);
    //查询所有已出租的数量
    int rentedCount(Map map);

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
    List<Map> queryChecked(Map map);
    int checkedCount(Map map);

    /**
     * 修改待审核的房源状态为已发布
     * @return
     */
    int updateChecked(int houseid);

    /**
     * 查询出所有已发布的房源
     * @return
     */
    List<Map> queryReleased(Map map);
    //查询所有已发布的数量
    int releasedCount(Map map);
    /**
     * 添加合同信息
     * @param houseContract
     * @return
     */
    int addContract(HouseContract houseContract);
    /**
     * 签订合同后将对应的房屋状态改为已出租
     */
    int beRented(int houseid);

    //根据房屋编号，向房屋表中查询出房东id
    Map queryLandlord(Integer houseid);
    //再根据房东编号，向用户表中查询出房东信息
    Map queryHost(Integer landlord);
    //根据租客姓名查询出租客的信息
    Map queryRenter(String ename);
    //根据房屋编号查询出房屋状态
    Integer queryState(Integer houseid);

    //查询出客户表中所有的id
    Integer[] cusId();
}
