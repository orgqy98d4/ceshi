package com.aaa.house.controllers;

import com.aaa.house.service.CustypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-29 10:11
 **/
@RestController
@RequestMapping("/custype")
public class CusTypeController {

    @Autowired
    private CustypeService custypeService;

    /**
     * 查询客户类型
     * @param
     * @return
     */
    @RequestMapping("/queryType")
    public Object queryType(){
        return custypeService.queryType();
    }
}
