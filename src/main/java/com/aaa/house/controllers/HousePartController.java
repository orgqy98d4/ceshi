package com.aaa.house.controllers;


import com.aaa.house.service.HouseFurnitureService;
import com.aaa.house.service.HouseService;
import com.aaa.house.service.HouseStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/part")
public class HousePartController {
    @Autowired
    private HouseStateService houseStateService;
    @Autowired
    private HouseFurnitureService houseFurnitureService;
    @Autowired
    private HouseService houseService;
    /**
     * 获取房屋状态列表
     * @return
     */
    @RequestMapping("/states")
    public Object queryStates(){
        System.out.println("状态集合："+houseStateService.queryStates());
        return houseStateService.queryStates();
    }
    /**
     * 获取一条房屋状态列表
     * @return
     */
    @RequestMapping("/state2")
    public Object queryState2(){
        System.out.println("待审核："+houseStateService.queryState2());
        return houseStateService.queryState2();
    }

    /**
     * 获取经纪人列表
     * @return
     */
    @RequestMapping("/agents")
    public Object queryAgents(){
        return houseStateService.queryAgents();
    }

    /**
     * 获取家具列表
     * @return
     */
    @RequestMapping("/furnitures")
    public Object queryFurnitures(){
        return houseFurnitureService.queryFurnitures();
    }

    /**
     * 根据状态查询房屋
     * @param map
     * @return
     */
    @RequestMapping("/queryByState")
    public Object queryByState(Map map){
        return houseService.queryHouses(map);
    }

    /**
     * 查询出所有待审核的房源
     * @return
     */
    @RequestMapping("/queryUnchecked")
    public Object queryUnchecked(){
        return houseStateService.queryUnchecked();
    }

    /**
     * 修改待审核的房源状态为已审核
     * @return
     */
    @RequestMapping("/updateUnchecked")
    public Object updateUnchecked(@RequestBody Map map){
        int houseid = (int) map.get("houseid");
        return houseStateService.updateUnchecked(houseid);
    }
    /**
     * 查询出所有已出租的房源
     * @return
     */
    @RequestMapping("/queryRented")
    public Object queryRented(){
        return houseStateService.queryRented();
    }

}
