package com.aaa.house.controllers;

import com.aaa.house.entity.Menu;
import com.aaa.house.service.MenuService;
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
 * @Date 2019/08/01  19:27
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    //注入角色Service
    @Autowired
    private MenuService menuService;

    /**
     * 查询所有权限列表
     * @param map
     * @return
     */
    @RequestMapping("/page")
    public Object queryAll(@RequestBody Map map){
        System.out.println(map+";............");
        Map mapResult=new HashMap();
        mapResult.put("menuList",menuService.queryAll(map));
        mapResult.put("total",menuService.queryPageCont(map));
        return mapResult;
    }

    /**
     * 添加权限内容
     * @param menu
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody Menu menu){
        return menuService.insertSelective(menu);
    }

    /**
     * 修改权限内容
     * @param menu
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody Menu menu){
        return menuService.updateByPrimaryKeySelective(menu);
    }

    /**
     * 删除权限内容
     * @param mid
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(@RequestParam Integer mid){
        return menuService.deleteByPrimaryKey(mid);
    }

//    -------------------------------------------------------------------

    /**
     * 获取所有父级菜单列表
     * @return
     */
    @RequestMapping("/getFatherMenu")
    public Object getFatherMenu(@RequestBody Map map){
        Map mapt=new HashMap();
        mapt.put("menuList",menuService.getFatherMenu(map));
        mapt.put("total",menuService.queryFatherCount(map));
        return mapt;
    }

    /**
     * 添加父菜单
     * @param menu
     * @return
     */
    @RequestMapping("/addFatherMenu")
    public Object addFatherMenu(@RequestBody Menu menu){
        System.out.println(menu+".........");
        return menuService.addFatherMenu(menu);
    }

    /**
     * 修改父菜单
     * @param menu
     * @return
     */
    @RequestMapping("/updateFatherMenu")
    public Object updateFatherMenu(Menu menu){
        return menuService.updateFatherMenu(menu);
    }


    /**
     * 删除父菜单
     * @param mid
     * @return
     */
    @RequestMapping("/deleteFatherMenu")
    public Object deleteFatherMenu(@RequestParam Integer mid){
        return menuService.deleteFatherMenu(mid);
    }

    /**
     * 获取所有子菜单
     * @return
     */
    @RequestMapping("/getSonMenu")
    public Object getSonMenu(@RequestBody Map map){
        System.out.println(map+"........");
        Map mapt=new HashMap();
        mapt.put("menuList",menuService.getSonMenu(map));
        mapt.put("total",menuService.getSonMenuCount(map));
        return mapt;
    }

    /**
     * 添加子菜单
     * @param menu
     * @return
     */
    @RequestMapping("/addSonMenu")
    public Object addSonMenu(@RequestBody Menu menu){
        System.out.println(menu+".........");
        return menuService.addSonMenu(menu);
    }

    /**
     * 修改子菜单
     * @param menu
     * @return
     */
    @RequestMapping("/updateSonMenu")
    public Object updateSonMenu(@RequestBody Menu menu){
        return menuService.updateSonMenu(menu);
    }


    /**
     * 删除子菜单
     * @param mid
     * @return
     */
    @RequestMapping("/deleteSonMenu")
    public Object deleteSonMenu(@RequestParam Integer mid){
        return menuService.deleteSonMenu(mid);
    }

}
