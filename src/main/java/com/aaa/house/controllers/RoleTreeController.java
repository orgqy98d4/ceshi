package com.aaa.house.controllers;

import com.aaa.house.service.RoleTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Local com.aaa.house.controllers
 * @Author ZongKeLi
 * @Date 2019/08/04  16:25
 * @Version 1.0
 */
@RestController
@RequestMapping("/roleTree")
public class RoleTreeController {

    @Autowired
    private RoleTreeService roleTreeService;

    Integer eid;

    /**
     * 获取角色树
     * @return
     */
    @RequestMapping("/tree")
    public Object tree(){
        System.out.println(roleTreeService.getRoleTree()+"...........");
        return roleTreeService.getRoleTree();
    }

    /**
     * 根据员工id获取角色树
     * @return
     */
    @RequestMapping("/getRolesByEid")
    public Object getRolesByEid(@RequestParam Integer eid){
        System.out.println(roleTreeService.getRolesByEid(eid));
        return roleTreeService.getRolesByEid(eid);
    }

    /**
     * 根据员工编号获取对应的所有角色编号
     * @param eid
     * @return
     */
    @RequestMapping("/getRidByEid")
    public Object getRidByEid(@RequestParam Integer eid){
        this.eid=eid;
        List<Integer> list = roleTreeService.getRidByEid(eid);
        return list;
    }

    /**
     * 为员工修改角色
     * @param rid
     * @return
     */
    @RequestMapping("/addMenu")
    public Boolean addMenu(@RequestParam(value = "rid[]",required = false) int[] rid){
        //先删除原有的角色
        roleTreeService.deleteMenuByRid(eid);
        Map map=new HashMap();
        map.put("eid",eid);
        map.put("rid",rid);
        int i = roleTreeService.addMenu(map);
        if (i>0){
            return true;
        }
        return false;
    }











}
