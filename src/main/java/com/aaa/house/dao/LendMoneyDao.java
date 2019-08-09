package com.aaa.house.dao;

import com.aaa.house.entity.LendMoney;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LendMoneyDao {

    /**
     * 添加借贷表
     */
    int insert(LendMoney record);

    /**
     * 删除借贷表
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    LendMoney queryId(Integer id);
    /**
     * 动态更新数据
     * @param record
     * @return
     */
    int update(LendMoney record);

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Map> queryAll(Map map);

    /**
     * 查询出来总数量
     * @param map
     * @return
     */
    int queryPageCont(Map map);
}
