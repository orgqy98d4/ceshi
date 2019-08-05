package com.aaa.house.controllers;

import com.aaa.house.service.PowerService;
import org.apache.ibatis.annotations.Insert;
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
@RequestMapping("/power")
public class PowerController {

    @Autowired
    private PowerService powerService;

    Integer rid;

    /**
     * 获取权限树
     * @return
     */
    @RequestMapping("/tree")
    public Object tree(){
        System.out.println(powerService.getPowers()+"...........");
        return powerService.getPowers();
    }

    /**
     * 根据角色编号获取对应的所有权限编号
     * @param rid
     * @return
     */
    public Object getMidByRid(@RequestParam Integer rid){
        this.rid=rid;
        List<Integer> list = powerService.getMidByRid(rid);
        return list;
    }

    /**
     * 为角色修改权限
     * @param mid
     * @return
     */
    public Object setPowerOrRole(@RequestParam int[] mid){
        //先删除原有的权限
        int result = powerService.deleteMenuByRid(rid);
        System.out.println(result);
        Map map=new HashMap();
        map.put("rid",rid);
        map.put("mid",mid);
        int i = powerService.addMenu(map);
        return i;
    }











}
