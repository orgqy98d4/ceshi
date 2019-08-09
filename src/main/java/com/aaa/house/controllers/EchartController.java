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
 * author:dyh
 * createTime:2019/8/2 16:38
 * versoin:1.0.0
 */
@RestController
@RequestMapping("echarts")
public class EchartController {


    @Autowired
    private EchartsService echartsService;
    /**
     * 返回展示数据
     * @return
     */
    @RequestMapping("getDataA")
    public Object getEchartDataA(@RequestParam Map mapParam){
        return  echartsService.getDataA(mapParam);
    }

}
