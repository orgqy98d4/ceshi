package com.aaa.house.controllers;


import com.aaa.house.service.HouseFurnitureService;
import com.aaa.house.service.HouseService;
import com.aaa.house.service.HouseStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/states")
    public Object queryStates(){
        System.out.println("状态集合："+houseStateService.queryStates());
        return houseStateService.queryStates();
    }

    @RequestMapping("/furnitures")
    public Object queryFurnitures(){
        return houseFurnitureService.queryFurnitures();
    }

    /**
     * 根据状态查询
     * @param map
     * @return
     */
    @RequestMapping("/queryByState")
    public Object queryByState(Map map){
        return houseService.queryHouses(map);
    }

}
