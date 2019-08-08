package com.aaa.house.controllers;

import com.aaa.house.entity.LendMoney;
import com.aaa.house.service.LendAuditService;
import com.aaa.house.service.LendMoneyService;
import com.aaa.house.util.FtpConfig;
import com.aaa.house.util.FtpUtil;
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
 * Created with IntelliJ IDEA.
 * User: 86187 杨金瑞
 * Date: 2019/8/7
 * Time: 14:00
 **/
@RestController
@RequestMapping("/lend")
public class LendMoneyController {
    //状态表
    @Autowired
    private LendAuditService lendAuditService;

    //这是借贷表
    @Autowired
    private LendMoneyService lendMoneyService;

    //注入FtpUtil类
    @Autowired
    private FtpUtil ftpUtil;

    //spring core包里面通过的资源加载器类
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private FtpConfig ftpConfig;
    /**
     * 查询出来所有结果
     * @param map
     * @return
     */
    @RequestMapping("/page")
    public Object queryAll(@RequestBody Map map){
        Map mapResult=new HashMap();
        mapResult.put("jdname",lendMoneyService.queryAll(map));
        mapResult.put("total",lendMoneyService.queryPageCont(map));
        return mapResult;
    }
    //查询还钱的状态
    @RequestMapping("/listAudit")
    public Object list(){
        return lendAuditService.queryAudit();
    }

    //查询合同的编号
    @RequestMapping("/listCon")
    public Object roleList(@RequestParam Integer contractid){
        return lendAuditService.queryCon(contractid);
    }


    /**
     * 添加内容
     * @param lendMoney
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody LendMoney lendMoney){
        return lendMoneyService.insert(lendMoney);
    }

    /**
     * 修改内容
     * @param lendMoney
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody LendMoney lendMoney){
        return lendMoneyService.update(lendMoney);
    }

    /**
     * 删除内容
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer id){
        return lendMoneyService.delete(id);
    }

    /**
     * 文件上传
     * @param headPic
     * @return
     */
    @RequestMapping("/uploadHeadPic")
    public Object uploadHeadPic(@RequestParam MultipartFile headPic){
        System.out.println("1111111111111111111111111111111111");
        String newFileName = ftpUtil.upLoad(headPic);
        System.out.println("2222222222222");
        String originalFilename = headPic.getOriginalFilename();
        Map map=new HashMap();
        map.put("newFileName",newFileName);
        map.put("originalFilename",originalFilename);
        System.out.println("333333333333333");
        return map;

    }

    /**
     * 显示头像
     * @param fileName
     * @return
     */
    @RequestMapping("/show")
    public ResponseEntity show(String fileName){
        //格式：ftp://admin:tiger@192.168.11.128/imgs/424a3c8b-590a-47ac-ac2e-d29597f2e57d.jpg
        return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpConfig.getFtpUserName()+":"+
                ftpConfig.getFtpPassWord()+"@"+ftpConfig.getRemoteIp()+ftpConfig.getRemotePath()+"/"+fileName));
    }
}
