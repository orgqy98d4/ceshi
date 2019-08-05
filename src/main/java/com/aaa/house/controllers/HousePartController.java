package com.aaa.house.controllers;


import com.aaa.house.entity.House;
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

    /**
     * 向房东表中添加一条信息
     * 先通过传过来的房屋实体获取到该房东的姓名，
     * 向房东表插入数据
     * 在dao层根据该房东姓名得到在房东表中的编号id
     * 房屋信息表中landlord即是该房东编号
     *将id通过setter方法为landlord赋值，
     * 以上步骤基本都发生在向房东表插入过数据之后，23333.....
     * @param house
     * @return
     */
    @RequestMapping("/addHost")
    public int addHost(@RequestBody House house){
        String cname = house.getCname();
        Integer houseid = house.getHouseid();
        int result=houseStateService.addHost(house);
        //根据房东查询出对应房东的id
        int id = houseStateService.getIdByCname(cname);
//        System.out.println("房东id:"+id);
//        System.out.println("房屋id:"+houseid);
        houseStateService.setHostId(id,houseid);
//        house.setLandlord(id);
        return result;
    }
    /**
     *前台传过来驳回理由，再传来一个房子实体
     * @param rejectReason
     * @param house
     * @return
     */
    @RequestMapping("/setRejectReason")
    public int setRejectReason(@RequestBody String rejectReason,@RequestBody House house) {
        Integer houseid = house.getHouseid();
        int result=houseStateService.setRejectReason(rejectReason,houseid);
        return result;
    }
}
