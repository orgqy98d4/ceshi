package com.aaa.house.controllers;


import com.aaa.house.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * fileName:EchartController
 * description:
 * author:zz
 * createTime:2019/8/2 16:38
 * versoin:1.0.0
 */
@RestController
@RequestMapping("echarts")
public class EchartController {


    /*@Autowired
    private EchartsService echartsService;*/
    /**
     * 返回展示数据
     * @return
     */
    @RequestMapping("getDataA")
    public Object getEchartDataA(@RequestParam Map mapParam){
       // return  echartsService.getDataA(mapParam);
        List<Map> mapList = new ArrayList<>();
        //[4300, 10000, 28000, 35000, 50000, 19000]
        //[5000, 14000, 28000, 31000, 42000, 21000],
        Map map =new HashMap();
        map.put("hk",4300);
        map.put("fk",5000);
        mapList.add(map);

        Map map1 =new HashMap();
        map1.put("hk",10000);
        map1.put("fk",14000);
        mapList.add(map1);

        Map map2 =new HashMap();
        map2.put("hk",28000);
        map2.put("fk",31000);
        mapList.add(map2);

        Map map3 =new HashMap();
        map3.put("hk",35000);
        map3.put("fk",31000);
        mapList.add(map3);

        Map map4 =new HashMap();
        map4.put("hk",50000);
        map4.put("fk",42000);
        mapList.add(map4);

        Map map5 =new HashMap();
        map5.put("hk",19000);
        map5.put("fk",21000);
        mapList.add(map5);
        return mapList;
    }

}
