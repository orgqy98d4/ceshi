package com.aaa.house.controllers;

import com.aaa.house.entity.Customer;
import com.aaa.house.service.CustomerService;
import com.aaa.house.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    private CustomerService customerServic;

    @Autowired
    private FtpUtil ftpUtil;

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

    /**
     * 文件上传
     * @param headPic
     * @return
     */
    @RequestMapping("/uploadHeadPic")
    public Object uploadHeadPic(@RequestParam MultipartFile headPic){
        System.out.println("......................");
        String originalFilename = headPic.getOriginalFilename();
        String newFileName = ftpUtil.upLoad(headPic);
        Map map  = new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }

}
