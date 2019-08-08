package com.aaa.house.service;

import com.aaa.house.dao.HouseStateMapper;
import com.aaa.house.entity.House;
import com.aaa.house.entity.HouseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseStateServiceImpl implements HouseStateService {
    @Autowired
    private HouseStateMapper houseStateMapper;

    /**
     * 获取状态集合列表
     * @return
     */
    @Override
    public List<Map> queryStates() {
        return houseStateMapper.queryStates();
    }
    /**
     * 只查询出一条状态，即待审核，id为2
     * @return
     */
    @Override
    public List<Map> queryState2() {
        return houseStateMapper.queryState2();
    }

    /**
     * 获取经纪人列表
     * @return
     */
    @Override
    public List<Map> queryAgents() {
        return houseStateMapper.queryAgents();
    }

    /**
     * 查询出所有待审核的房源
     * @return
     */
    @Override
    public List<Map> queryUnchecked(Map map) {
        return houseStateMapper.queryUnchecked(map);
    }
    //查询出所有待审核的房源数量
    @Override
    public int uncheckedCount(Map map) {
        return houseStateMapper.uncheckedCount(map);
    }

    /**
     * 修改待审核的房源状态为已审核
     * @return
     */
    @Override
    public int updateUnchecked(int houseid) {
        return houseStateMapper.updateUnchecked(houseid);
    }


    /**
     * 查询出所有已出租的房源
     * @return
     */
    @Override
    public List<Map> queryRented(Map map) {
        return houseStateMapper.queryRented(map);
    }
    //查询所有已出租的数量
    @Override
    public int rentedCount(Map map) {
        return houseStateMapper.rentedCount(map);
    }

    /**
     * 向房东表中添加一条信息
     * @param house
     * @return
     */
    @Override
    public int addHost(House house) {
        return houseStateMapper.addHost(house);
    }
    /**
     * 根据房东姓名获取该房东对应的编号id
     * @param cname
     * @return
     */
    @Override
    public int getIdByCname(String cname) {
        return houseStateMapper.getIdByCname(cname);
    }
    /**
     * 获取到房屋编号后为相应的房屋设置房东编号
     * @param id
     * @param houseid
     * @return
     */
    @Override
    public int setHostId(Integer id, Integer houseid) {
        return houseStateMapper.setHostId(id,houseid);
    }

    /**
     * 根据编号，书写驳回理由
     * @param house
     * @return
     */
    @Override
    public int setRejectReason(House house) {
        return houseStateMapper.setRejectReason(house);
    }

    /**
     * 查询出所有已审核的房源
     * @return
     */
    @Override
    public List<Map> queryChecked(Map map) {
        return houseStateMapper.queryChecked(map);
    }
    /**
     * 查询出所有已审核的房源数量
     * @return
     */
    @Override
    public int checkedCount(Map map) {
        return houseStateMapper.checkedCount(map);
    }

    /**
     * 修改待审核的房源状态为已发布
     * @param houseid
     * @return
     */
    @Override
    public int updateChecked(int houseid) {
        return houseStateMapper.updateChecked(houseid);
    }
    /**
     * 查询出所有已发布的房源
     * @return
     */
    @Override
    public List<Map> queryReleased(Map map) {
        return houseStateMapper.queryReleased(map);
    }
    //查询所有已发布的数量
    @Override
    public int releasedCount(Map map) {
        return houseStateMapper.releasedCount(map);
    }

    /**
     * 添加合同信息
     * @param houseContract
     * @return
     */
    @Override
    public int addContract(HouseContract houseContract) {
        return houseStateMapper.addContract(houseContract);
    }
    /**
     * 签订合同后将对应的房屋状态改为已出租
     */
    @Override
    public int beRented(int houseid) {
        return houseStateMapper.beRented(houseid);
    }

    //根据房屋编号，向房屋表中查询出房东id
    @Override
    public Map queryLandlord(Integer houseid) {
        return houseStateMapper.queryLandlord(houseid);
    }
    //再根据房东编号，向用户表中查询出房东信息
    @Override
    public Map queryHost(Integer landlord) {
        return houseStateMapper.queryHost(landlord);
    }
    //根据租客姓名查询出租客的信息
    @Override
    public Map queryRenter(String ename) {
        return houseStateMapper.queryRenter(ename);
    }

    //根据房屋编号查询出房屋状态
    @Override
    public Integer queryState(Integer houseid) {
        return houseStateMapper.queryState(houseid);
    }
}
