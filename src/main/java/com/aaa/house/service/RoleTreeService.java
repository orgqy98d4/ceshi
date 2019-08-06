package com.aaa.house.service;

/**
 * @Local com.aaa.house.dao
 * @Author ZongKeLi
 * @Date 2019/08/04  16:00
 * @Version 1.0
 */

import com.aaa.house.entity.RoleTreeNode;
import com.aaa.house.entity.TreeNode;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 角色树
 */
public interface RoleTreeService {

    /**
     * 根据员工id获取对应的角色
     * @param eid
     * @return
     */
    List<RoleTreeNode> getRolesByEid(Integer eid);


    /**
     * 获取所有角色树
     * @return
     */
    List<RoleTreeNode> getRoleTree();

    /**
     * 根据员工编号获取对应的所有角色编号
     * @param eid
     * @return
     */
    List<Integer> getRidByEid(Integer eid);

    /**
     * 根据员工编号删除对应的所有角色
     * @param id
     * @return
     */
    int deleteMenuByRid(Integer id);

    /**
     * 为员工添加角色
     * @param map
     * @return
     */
    int addMenu(Map map);
}
