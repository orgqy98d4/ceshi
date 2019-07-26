package com.aaa.house.controllers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Local com.aaa.house.controllers
 * @Author ZongKeLi
 * @Date 2019/07/25  19:14
 * @Version 1.0
 */
@RestController
public class LoginController {

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
        //构建Subject对象（当前用户）
        Subject subject = SecurityUtils.getSubject();
        String msg="";
        if (eusername!=null&&!"".equals(eusername)) {
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
