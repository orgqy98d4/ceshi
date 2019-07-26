package com.aaa.house.dao;

import com.aaa.house.entity.Empstate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpstateMapper {
    /**
     * 查询出来状态数据
     * @return
     */
    List<Empstate> queryState();
}