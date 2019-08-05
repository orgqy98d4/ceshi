package com.aaa.house.service;

import com.aaa.house.dao.RoleMapper;
import com.aaa.house.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Local com.aaa.house.service
 * @Author ZongKeLi
 * @Date 2019/07/29  10:28
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Integer rid) {
        return roleMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> queryAll(Map map) {
        return roleMapper.queryAll(map);
    }

    @Override
    public Role getRoleByName(Map map) {
        return roleMapper.getRoleByName(map);
    }

    @Override
    public int queryPageCont(Map map) {
        return roleMapper.queryPageCont(map);
    }
}
