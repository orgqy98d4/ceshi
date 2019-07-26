package com.aaa.house.service;

import com.aaa.house.entity.Empstate;

import java.util.List;

public interface EmpstateService {
    int deleteByPrimaryKey(Integer id);

    int insert(Empstate record);

    int insertSelective(Empstate record);

    Empstate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empstate record);

    int updateByPrimaryKey(Empstate record);

    /**
     * 查询出来部门名称
     * @return
     */
    List<Empstate> queryState();
}
