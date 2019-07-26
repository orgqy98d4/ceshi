package com.aaa.house.service;

import com.aaa.house.entity.Empstate;

import java.util.List;

public interface EmpstateService {
    /**
     * 查询出来部门名称
     * @return
     */
    List<Empstate> queryState();
}
