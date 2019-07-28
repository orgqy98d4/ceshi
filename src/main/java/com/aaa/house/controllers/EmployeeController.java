package com.aaa.house.controllers;

import com.aaa.house.entity.Employee;
import com.aaa.house.service.EmployeeService;
import com.aaa.house.service.EmpstateService;
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
 * Created with IntelliJ IDEA.
 * User: 86187 杨金瑞
 * Date: 2019/7/25
 * Time: 21:59
 **/
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    //员工业务层
    @Autowired
    private EmployeeService employeeService;
    //注入FtpUtil类
    @Autowired
    private FtpUtil ftpUtil;
    //员工状态
    @Autowired
    private EmpstateService empstateService;

    /**
     * 查询出来所有结果
     * @param map
     * @return
     */
    @RequestMapping("/page")
    public Object queryAll(@RequestBody Map map){
        System.out.println(map+".........");
        Map mapResult=new HashMap();
        mapResult.put("empList",employeeService.queryAll(map));
        mapResult.put("total",employeeService.queryPageCont(map));
        return mapResult;
    }
    //查询在职状态
    @RequestMapping("/list")
    public Object list(){
        return empstateService.queryState();
    }
    /**
     * 添加内容
     * @param emp
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody Employee emp){
        return employeeService.insertSelective(emp);
    }

    /**
     * 修改内容
     * @param emp
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody Employee emp){
        return employeeService.updateByPrimaryKeySelective(emp);
    }

    /**
     * 删除内容
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer id){
        return employeeService.deleteByPrimaryKey(id);
    }

    /**
     * 文件上传
     * @param headPic
     * @return
     */
    @RequestMapping("/uploadHeadPic")
    public Object uploadHeadPic(@RequestParam MultipartFile headPic){
        String newFileName = ftpUtil.upLoad(headPic);
        String originalFilename = headPic.getOriginalFilename();
        Map map=new HashMap();
        map.put("newFileName",newFileName);
        map.put("originalFilename",originalFilename);
        return map;

    }
}
