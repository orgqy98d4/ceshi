package com.aaa.house.controllers;

import com.aaa.house.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Local com.aaa.house.controllers
 * @Author ZongKeLi
 * @Date 2019/07/25  19:14
 * @Version 1.0
 */
@RestController
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 登录验证
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public Object login(@RequestBody Map map){
        System.out.println(map+"...............");
        //获取登录账号及密码
        String eusername = map.get("eusername") + "";
        String epassword = map.get("epassword") + "";
        //判断登录的账号是否可用
        Map mapt=new HashMap();
        mapt.put("eusername",eusername);
        mapt.put("start",0);
        mapt.put("pageSize",100);
        List<Map> list = employeeService.queryAll(mapt);
        //构建Subject对象（当前用户）
        Subject subject = SecurityUtils.getSubject();
        String msg="";
        if (list!=null&&list.size()>0){
            Map map1 = list.get(0);
            //获取登录用户的状态
            Object o = map1.get("stateid");
            System.out.println(o);
            try {
                if (o.equals(4)){
                    throw new UnknownAccountException("用户不存在");
                }else if (eusername!=null&&!"".equals(eusername)) {
                    //构建认证的身份令牌
                    UsernamePasswordToken token = new UsernamePasswordToken(eusername, epassword);
                    try {
                        //将身份令牌放进去
                        subject.login(token);
                        msg="suc";
                    } catch (AuthenticationException exception) {
//                //清除session
                        token.clear();
                        //自定义信息
                        if (UnknownAccountException.class.getName().equals(exception.getClass().getName())){
                            msg="您输入的账号不存在";
                        }else if(IncorrectCredentialsException.class.getName().equals(exception.getClass().getName())){
                            msg="账号或密码不匹配";
                        }else if (LockedAccountException.class.getName().equals(exception.getClass().getName())){
                            msg="您的账号已被锁定，无法登录系统";
                        }else {
                            msg="账号或密码错误";
                        }
                    }
                }
            } catch (UnknownAccountException e) {
                  msg="该账号已被禁用";
            }
        }
        Map maptmp=new HashMap();
        maptmp.put("msg",msg);
        return maptmp;
    }

    /**
     * 注销
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public Object logouut(HttpSession session){
        session.invalidate();
        return 1;
    }
}
