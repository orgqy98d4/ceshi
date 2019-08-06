package com.aaa.house.controllers;

import com.aaa.house.entity.Customer;
import com.aaa.house.service.CustomerService;
import com.aaa.house.util.FtpConfig;
import com.aaa.house.util.FtpUtil;
import com.aaa.house.util.ISysConstants;
import com.aaa.house.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
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
    private CustomerService customerService;

    @Autowired
    private FtpUtil ftpUtil;

    @Autowired
    private FtpConfig ftpConfig;

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * 添加修改
     * @param customer
     * @return
     */
    @RequestMapping("/insert")
    public Result insert(Customer customer){
        Result result = new Result();
        if (customer.getId() == null || customer.getId() == 0) {
            int addCus = customerService.insert(customer);
            if (addCus > 0) {
                result.setCode(ISysConstants.SUCCESSCODE);
                result.setMsg("添加成功");
            } else {
                result.setCode(ISysConstants.ERRORCODE);
                result.setMsg("添加失败");
            }
        } else {
            int updateCus = customerService.update(customer);
            if (updateCus > 0) {
                result.setCode(ISysConstants.SUCCESSCODE);
                result.setMsg("修改成功");
            } else {
                result.setCode(ISysConstants.ERRORCODE);
                result.setMsg("修改失败");
            }
        }
        return result;
    }

    /**
     * 修改
     * @param customer
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody Customer customer){
        return customerService.update(customer);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer id){
        return customerService.delete(id);
    }

    /**
     * 查询全部
     * @param
     * @return
     */
    @RequestMapping("/page")
    public Object queryAll(@RequestBody Map map){
        Map mapResult =new HashMap();
        mapResult.put("customerList",customerService.queryAll(map));
        mapResult.put("total",customerService.queryPageCount(map));
        return mapResult;
    }

    /**
     * 查询单个
     * */
    @RequestMapping("/select")
    public Object select(Integer id){
        return customerService.select(id);
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

    /**
     * 显示头像
     * */
    @RequestMapping("/show")
    public ResponseEntity show(String fileName){
        return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpConfig.getFtpUserName()+":"+ftpConfig.getFtpPassWord()+"@"+ftpConfig.getRemoteIp()+ftpConfig.getRemotePath()+"/"+fileName));
    }

    /**
     * 从Session中取出用户信息
     */
    @RequestMapping("/getCusFromSession")
    public Result getCusFromSession(){
        Customer customer = customerService.getCusFromSession();
        if (customer !=null){
            return new Result(ISysConstants.SUCCESSCODE,"存在",customer);
        } else {
            return new Result(ISysConstants.ERRORCODE,"请重新登录",null);
        }
    }

}
