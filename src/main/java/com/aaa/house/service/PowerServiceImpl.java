package com.aaa.house.service;

import com.aaa.house.dao.PowerMapper;
import com.aaa.house.entity.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Local com.aaa.house.service
 * @Author ZongKeLi
 * @Date 2019/08/04  16:13
 * @Version 1.0
 */
@Service
public class PowerServiceImpl implements PowerService{

    @Autowired
    private PowerMapper powerMapper;
    /**
     * 获取所有权限
     * @return
     */
    @Override
    public List<TreeNode> getPowers() {
        //获取所有节点列表
        List<TreeNode> powers = powerMapper.getPowers();
        //定义临时集合，用于存放拼装后的树数据
        List<TreeNode> tmpTreeData = new ArrayList<>();
        if(powers!=null&&powers.size()>0){
            for (TreeNode power : powers) {
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
    private void bindChildren(TreeNode treeNode,List<TreeNode> powers) {
        List<TreeNode> tmpChildrens = null;
        for (TreeNode power : powers) {
            //如果当前结点的id等于其中某个节点的父id,那么当前节点就是这个节点的父亲
            if (treeNode.getMid() == power.getPid()) {
                List<TreeNode> childrens = treeNode.getChildren();
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
     * 根据角色编号获取对应的权限编号集合
     * @param rid
     * @return
     */
    @Override
    public List<Integer> getMidByRid(Integer rid) {
        List<Integer> list = powerMapper.getMidByRid(rid);
        return list;
    }

    /**
     * 根据橘色编号删除对应的权限
     * @param rid
     * @return
     */
    @Override
    public int deleteMenuByRid(Integer rid) {
        return powerMapper.deleteMenuByRid(rid);
    }

    /**
     * 为角色增加权限
     * @param map
     * @return
     */
    @Override
    public int addMenu(Map map) {
        int rid = (int) map.get("rid");
        int[] mids= (int[]) map.get("mid");
        for (int i = 0; i < mids.length; i++) {
            powerMapper.addMenu(rid,mids[i]);
        }
        return mids.length;
    }
}
