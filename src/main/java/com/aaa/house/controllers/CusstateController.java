package com.aaa.house.controllers;

import com.aaa.house.service.CusstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-29 10:11
 **/
@RestController
@RequestMapping("/cusstate")
public class CusstateController {

    @Autowired
    private CusstateService cusstateService;

    /**
     * 查询客户状态
     * @param
     * @return
     */
    @RequestMapping("/queryState")
    public Object queryState(){
        return cusstateService.queryState();
    }
}
