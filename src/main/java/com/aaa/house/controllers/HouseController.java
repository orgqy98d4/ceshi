package com.aaa.house.controllers;

import com.aaa.house.entity.House;
import com.aaa.house.service.HouseFurnitureService;
import com.aaa.house.service.HouseService;
import com.aaa.house.service.HouseStateService;
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

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private FtpUtil ftpUtil;
    @Autowired
    private FtpConfig ftpConfig;
    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * 按照条件进行查询，并且分页
     * @param map
     * @return
     */
    @RequestMapping("/houselist")
    public Object queryByConditionWithPage(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("houseList",houseService.queryHouses(map));
        map1.put("total",houseService.queryHouseCount(map));
//        System.out.println("查询房屋："+map1);
        return map1;
    }
    /**
     *添加房屋
     * @param
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestBody House house){
        return houseService.insertSelective(house);
    }
    /**
     *更新房屋信息
     * @param
     * @return
     */
    @RequestMapping("/update")
    public Object update(@RequestBody House house) {
        System.out.println(houseService.updateByPrimaryKeySelective(house));
        return houseService.updateByPrimaryKeySelective(house);
    }
    /**
     *根据房屋编号进行删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer id) {
        return houseService.deleteByPrimaryKey(id);
    }
    /**
     * 上传房屋图片，参数为图片，
     * 将获取到的原始文件名和上传后编码过的文件名返回
     */
    @RequestMapping("/uploadHeadPic")
    public Object uploadHimg(@RequestParam MultipartFile headPic){
        System.out.println("图片："+headPic);
        //原始文件名
        String originalFilename = headPic.getOriginalFilename();
        //上传文件后得到一个新的文件名
        String newFileName = ftpUtil.upLoad(headPic);
        Map map=new HashMap();
        map.put("originalFilename",originalFilename);
        map.put("newFileName",newFileName);
        return map;
    }
    /**
     * 显示房屋图片
     */
    @RequestMapping("/show")
    public ResponseEntity show(String fileName){
        System.out.println("文件名："+fileName);
        //ftp://admin:admin@192.168.11.116/ftp-dir-xn/84c7f5ed-17e1-4f9a-a775-552254d66386.jpg
        return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpConfig.getFtpUserName()+":"+
                ftpConfig.getFtpPassWord()+"@"+ftpConfig.getRemoteIp()+ftpConfig.getRemotePath()+"/"+fileName));
    }
//    /**
//     * 头像下载
//     * @param fileName
//     * @param response
//     */
//    @RequestMapping("/downLoad")
//    public void downLoad(String fileName,String originalName, HttpServletResponse response){
//        //调用封装方法
//        ftpUtil.downLoad(fileName,response,originalName);
//    }

}
