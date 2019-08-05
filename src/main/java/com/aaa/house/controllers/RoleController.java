package com.aaa.house.controllers;

import com.aaa.house.entity.Role;
import com.aaa.house.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Local com.aaa.house.controllers
 * @Author ZongKeLi
 * @Date 2019/08/01  18:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    //注入角色Service
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色列表
     * @param map
     * @return
     */
    @RequestMapping("/page")
    public Object queryAll(@RequestBody Map map){
        Map mapResult=new HashMap();
        mapResult.put("roleList",roleService.queryAll(map));
        mapResult.put("total",roleService.queryPageCont(map));
        return mapResult;
    }

    /**
     * 根据角色编号或名字获取角色
     * @param map
     * @return
     */
    @RequestMapping("/getRoleByName")
    public Object getRoleByName(@RequestBody Map map){
        System.out.println(map+"........");
        Map mapt=new HashMap();
        mapt.put("roles",roleService.getRoleByName(map));
        return mapt;
    }
    /**
     * 添加角色内容
     * @param role
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody Role role){
        return roleService.insertSelective(role);
    }

    /**
     * 修改角色内容
     * @param role
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody Role role){
        return roleService.updateByPrimaryKeySelective(role);
    }

    /**
     * 删除角色内容
     * @param rid
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(@RequestParam Integer rid){
        return roleService.deleteByPrimaryKey(rid);
    }
}
