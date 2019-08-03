package com.aaa.house.service;

import com.aaa.house.dao.HouseStateMapper;
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
}
