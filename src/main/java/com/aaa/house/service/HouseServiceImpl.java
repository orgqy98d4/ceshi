package com.aaa.house.service;

import com.aaa.house.dao.HouseMapper;
import com.aaa.house.entity.House;
import com.aaa.house.entity.HouseFurniture;
import com.aaa.house.util.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper  houseMapper;

    /**
     * 查询出所有房屋
     * @param map
     * @return
     */
    @Override
    public List<Map> queryHouses(Map map) {
        return houseMapper.queryHouses(map);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(House record) {
        return 0;
    }

    @Override
    public int insertSelective(House record) {
        return houseMapper.insertSelective(record);
    }

    @Override
    public House selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(House record) {
        return houseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(House record) {
        return 0;
    }

    /**
     * 保存家具信息
     * @param houseFurniture
     * @return
     */
    @Override
    public int saveFurniture(HouseFurniture houseFurniture) {
        return houseMapper.saveFurniture(houseFurniture);
    }


    /**
     * 根据条件查询出所有符合条件的房屋总数
     * @param map
     * @return
     */
    @Override
    public int queryHouseCount(Map map) {
        return houseMapper.queryHouseCount(map);
    }


    /**
     * 添加房屋信息
     * @param
     * @return
     */
//    @Override
//    public int save(House house) {
//        return houseMapper.insertSelective(house);
//    }
    /**
     *更新房屋信息
     * @param
     * @return
     */
//    @Override
//    public int modify(House house) {
//        return houseMapper.updateByPrimaryKeySelective(house);
//    }
//    /**
//     *根据房屋编号进行删除
//     * @param houseid
//     * @return
//     */
//    @Override
//    public int delete(Integer houseid) {
//        return houseMapper.deleteByPrimaryKey(houseid);
//    }

    /**
     * 前台获取全部已发布的房屋列表
     */
    @Override
    public Page houseList(House house, int current, int pageSize) {
        RowBounds rowBounds = new RowBounds((current - 1) * pageSize, pageSize);
        List<House> list = houseMapper.houseList(house, rowBounds);
        for (House h : list) {
            Integer hid = h.getHouseid();
            List<String> houseInstallation = houseMapper.houseInstallation(hid);
            h.setInstallation(houseInstallation);
        }
        Integer count = houseMapper.count(house);
        return new Page(list, count);
    }
}
