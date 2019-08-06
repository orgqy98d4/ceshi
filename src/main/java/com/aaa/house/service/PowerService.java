package com.aaa.house.service;

import com.aaa.house.entity.TreeNode;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Local com.aaa.house.service
 * @Author ZongKeLi
 * @Date 2019/08/04  16:11
 * @Version 1.0
 */
public interface PowerService  {

    /**
     * 根据员工id获取对应的权限
     * @param id
     * @return
     */
    List<TreeNode> getPowersById(Integer id);

    /**
     * 获取所有权限
     * @return
     */
    List<TreeNode> getPowers();


    /**
     * 根据角色编号获取对应的所有权限编号
     * @param rid
     * @return
     */
     List<Integer> getMidByRid(Integer rid);

    /**
     * 根据角色编号删除对应的所有权限
     * @param rid
     * @return
     */
    int deleteMenuByRid(Integer rid);

    /**
     * 为角色添加权限
     * @param map
     * @return
     */
    int addMenu(Map map);
}
