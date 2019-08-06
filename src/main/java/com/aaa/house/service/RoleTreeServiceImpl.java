package com.aaa.house.service;

import com.aaa.house.dao.RoleTreeMapper;
import com.aaa.house.entity.RoleTreeNode;
import com.aaa.house.entity.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Local com.aaa.house.service
 * @Author ZongKeLi
 * @Date 2019/08/06  16:48
 * @Version 1.0
 */
@Service
public class RoleTreeServiceImpl implements RoleTreeService {
    @Autowired
    private RoleTreeMapper roleTreeMapper;

    /**
     * 根据员工id获取对应的角色
     * @param eid
     * @return
     */
    @Override
    public List<RoleTreeNode> getRolesByEid(Integer eid) {
        //获取所有节点列表
        List<RoleTreeNode> powers = roleTreeMapper.getRolesByEid(eid);
        //定义临时集合，用于存放拼装后的树数据
        List<RoleTreeNode> tmpTreeData = new ArrayList<>();
        if(powers!=null&&powers.size()>0){
            for (RoleTreeNode power : powers) {
                //判断是否是一级节点
                if (power.getPid()==0){
                    tmpTreeData.add(power);
                    //查找孩子并且绑定
                    bindChildren(power,powers);
                }
            }

        }
        return tmpTreeData;
    }

    /**
     * 获取所有角色树
     * @return
     */
    @Override
    public List<RoleTreeNode> getRoleTree() {

        //获取所有节点列表
        List<RoleTreeNode> powers = roleTreeMapper.getRoleTree();
        //定义临时集合，用于存放拼装后的树数据
        List<RoleTreeNode> tmpTreeData = new ArrayList<>();
        if(powers!=null&&powers.size()>0){
            for (RoleTreeNode power : powers) {
                //判断是否是一级节点
                if (power.getPid()==0){
                    tmpTreeData.add(power);
                    //查找孩子并且绑定
                    bindChildren(power,powers);
                }
            }

        }
        return tmpTreeData;
    }

    /**
     * 查找孩子并且绑定的过程
     * @param treeNode
     * @param powers
     */
    private void bindChildren(RoleTreeNode treeNode,List<RoleTreeNode> powers) {
        List<RoleTreeNode> tmpChildrens = null;
        for (RoleTreeNode power : powers) {
            //如果当前结点的id等于其中某个节点的父id,那么当前节点就是这个节点的父亲
            if (treeNode.getRid() == power.getPid()) {
                List<RoleTreeNode> childrens = treeNode.getChildren();
                //添加第一个孩子时，要判断是否已经存在孩子
                if (childrens == null || childrens.size() == 0) {
                    //第一次要创建一个临时集合来装孩子
                    tmpChildrens = new ArrayList<>();
                    tmpChildrens.add(power);
                    treeNode.setChildren(tmpChildrens);
                } else {
                    childrens.add(power);
                }
                //递归调用自己查找孩子并且绑定
                bindChildren(power, powers);
            }
        }
    }

    /**
     * 根据员工编号获取对应的所有角色编号
     * @param eid
     * @return
     */
    @Override
    public List<Integer> getRidByEid(Integer eid) {
        return roleTreeMapper.getRidByEid(eid);
    }
    /**
     * 根据员工编号删除对应的所有角色
     * @param id
     * @return
     */
    @Override
    public int deleteMenuByRid(Integer id) {
        return roleTreeMapper.deleteMenuByRid(id);
    }
    /**
     * 为员工添加角色
     * @param map
     * @return
     */
    @Override
    public int addMenu(Map map) {
        int eid = (int) map.get("eid");
        int[] rids= (int[]) map.get("rid");
        for (int i = 0; i < rids.length; i++) {
            roleTreeMapper.addMenu(eid,rids[i]);
        }
        return rids.length;
    }
}
