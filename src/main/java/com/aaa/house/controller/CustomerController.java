package com.aaa.house.controller;

import com.aaa.house.entity.Customer;
import com.aaa.house.service.CustomerServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-26 10:51
 **/
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServic customerServic;

    /**
     * 添加
     * @param customer
     * @return
     */
    @RequestMapping("/insert")
    public Object insert(@RequestBody Customer customer){
        return customerServic.insert(customer);
    }

    /**
     * 修改
     * @param customer
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody Customer customer){
        return customerServic.update(customer);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer id){
        return customerServic.delete(id);
    }

    /**
     * 查询全部
     * @param
     * @return
     */
    @RequestMapping("/page")
    public Object queryAll(@RequestBody Map map){
        Map mapResult =new HashMap();
        mapResult.put("customerList",customerServic.queryAll(map));
        mapResult.put("total",customerServic.queryPageCount(map));
        return mapResult;
    }

}
