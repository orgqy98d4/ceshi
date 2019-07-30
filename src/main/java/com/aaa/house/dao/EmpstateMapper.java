package com.aaa.house.dao;

import com.aaa.house.entity.Empstate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpstateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Empstate record);

    int insertSelective(Empstate record);

    Empstate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empstate record);

    int updateByPrimaryKey(Empstate record);

    /**
     * 状态列表
     * @return
     */
    List<Empstate> queryState();
}