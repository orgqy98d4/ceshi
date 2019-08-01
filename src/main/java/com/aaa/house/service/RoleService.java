package com.aaa.house.service;

import com.aaa.house.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * 删除
     * @param rid
     * @return
     */
    int deleteByPrimaryKey(Integer rid);

    /**
     * 录入
     * @param record
     * @return
     */
    int insert(Role record);

    /**
     * 动态sql录入
     * @param record
     * @return
     */
    int insertSelective(Role record);

    /**
     * 根据主键查询
     * @param rid
     * @return
     */
    Role selectByPrimaryKey(Integer rid);

    /**
     * 动态更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Role record);

    /**
     * 角色列表
     * @return
     */
    List<Role> queryAll();
}