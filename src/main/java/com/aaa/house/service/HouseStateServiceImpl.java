package com.aaa.house.service;

import com.aaa.house.dao.HouseStateMapper;
import com.aaa.house.entity.House;
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
    public List<Map> queryUnchecked() {
        return houseStateMapper.queryUnchecked();
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
    public List<Map> queryRented() {
        return houseStateMapper.queryRented();
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
     * @param rejectReason
     * @param houseid
     * @return
     */
    @Override
    public int setRejectReason(String rejectReason,Integer houseid) {
        return houseStateMapper.setRejectReason(rejectReason,houseid);
    }
}
