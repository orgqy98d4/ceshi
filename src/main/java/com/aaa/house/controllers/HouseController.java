package com.aaa.house.controllers;

import com.aaa.house.entity.FollowHouse;
import com.aaa.house.entity.House;
import com.aaa.house.entity.HouseFurniture;
import com.aaa.house.service.HouseFurnitureService;
import com.aaa.house.service.HouseService;
import com.aaa.house.service.HouseStateService;
import com.aaa.house.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
        Map map=new HashMap();
        map.put("house",house);
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
//        System.out.println("图片："+headPic);
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
//        System.out.println("文件名："+fileName);
        //ftp://admin:admin@192.168.11.116/ftp-dir-xn/84c7f5ed-17e1-4f9a-a775-552254d66386.jpg
        return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpConfig.getFtpUserName()+":"+
                ftpConfig.getFtpPassWord()+"@"+ftpConfig.getRemoteIp()+ftpConfig.getRemotePath()+"/"+fileName));
    }

    /**
     * 配置家具
     * 参数有：自动生成的房屋编号
     * @param
     * @return
     */
    @RequestMapping("/saveFurniture")
    public Object saveFurniture(HttpServletRequest request){
        int result=0;
        //通过参数名获取家具的编号，进行分割
        String str=request.getParameter("furnitures");
        //房子编号
        int houseid = Integer.parseInt(request.getParameter("houseid"));
        String[] strings = str.split(",");
        System.out.println(strings);

        //生成一个HouseFurniture对象，设置houseid
        //每次循环都会创建一个HouseFurniture对象，然后设房间编号，家具编号，再同时存入数据
        HouseFurniture houseFurniture1=null;
        for (String string : strings) {
            houseFurniture1=new HouseFurniture();
            houseFurniture1.setHouseid(houseid);
            houseFurniture1.setFurnitureid(Integer.valueOf(string));
            result=houseService.saveFurniture(houseFurniture1);
        }
        //将家具编号存入HouseFurniture对象
//        houseFurniture1.setFurnitureid(strings);
        if (result>0){
            return "true";
        }else{
            return "false";
        }

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

    /**
     * 前台获取房源列表
     */
    @RequestMapping("/houseList/{current}/{pageSize}")
    public Page houseList(House house, @PathVariable int current, @PathVariable int pageSize) {
        return houseService.houseList(house, current, pageSize);
    }

    /**
     * 前台根据ID获取房屋详细信息
     */
    @RequestMapping("houseDetail")
    public Map<String, Object> houseDetail(Integer id) {
        return houseService.houseDetail(id);
    }

    /**
     * 关注房源
     */
    @RequestMapping("followHouse")
    public Result followHouse(Integer houseid) {
        int i = houseService.followhouse(houseid);
        if (i > 0) {
            return new Result(ISysConstants.SUCCESSCODE, "已关注", null);
        } else {
            return new Result(ISysConstants.SUCCESSCODE, "关注失败", null);
        }
    }

    /**
     * 判断是否关注
     */
    @RequestMapping("isFollow")
    public Result isFollow(Integer houseid) {
        FollowHouse follow = houseService.isFollow(houseid);
        if (follow != null) {
            return new Result(ISysConstants.SUCCESSCODE, "", follow);
        } else {
            return new Result(ISysConstants.ERRORCODE, "", follow);
        }
    }

    /**
     * 用户关注的房源
     */
    @RequestMapping("myFollowHouse")
    public Page myFollowHouse() {
        return houseService.myFollowHouse();
    }

    /**
     * 取消关注
     */
    @RequestMapping("unFollow")
    public Result unFollow(Integer houseid) {
        int i = houseService.delFollow(houseid);
        if (i > 0) {
            return new Result(ISysConstants.SUCCESSCODE, "", null);
        } else {
            return new Result(ISysConstants.ERRORCODE, "", null);
        }
    }

}
