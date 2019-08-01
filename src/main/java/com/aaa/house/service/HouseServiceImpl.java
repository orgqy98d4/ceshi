package com.aaa.house.service;

import com.aaa.house.dao.HouseMapper;
import com.aaa.house.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper  HouseMapper;

    /**
     * 查询出所有房屋
     * @param map
     * @return
     */
    @Override
    public List<Map> queryHouses(Map map) {
        return HouseMapper.queryHouses(map);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return HouseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(House record) {
        return 0;
    }

    @Override
    public int insertSelective(House record) {
        return HouseMapper.insertSelective(record);
    }

    @Override
    public House selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(House record) {
        return HouseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(House record) {
        return 0;
    }

    /**
     * 根据条件查询出所有符合条件的房屋总数
     * @param map
     * @return
     */
    @Override
    public int queryHouseCount(Map map) {
        return HouseMapper.queryHouseCount(map);
    }


    /**
     * 添加房屋信息
     * @param
     * @return
     */
//    @Override
//    public int save(House house) {
//        return HouseMapper.insertSelective(house);
//    }
    /**
     *更新房屋信息
     * @param
     * @return
     */
//    @Override
//    public int modify(House house) {
//        return HouseMapper.updateByPrimaryKeySelective(house);
//    }
//    /**
//     *根据房屋编号进行删除
//     * @param houseid
//     * @return
//     */
//    @Override
//    public int delete(Integer houseid) {
//        return HouseMapper.deleteByPrimaryKey(houseid);
//    }
}
