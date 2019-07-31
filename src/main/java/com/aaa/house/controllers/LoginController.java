package com.aaa.house.controllers;

import com.aaa.house.entity.Customer;
import com.aaa.house.service.LoginService;
import com.aaa.house.util.CusUtil;
import com.aaa.house.util.ISysConstants;
import com.aaa.house.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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
/*=====================================客户登录部分(开始)=====================================*/

    @Autowired
    LoginService loginService;

    /**客户登录
     * @param customer
     * @return
     */
    @RequestMapping("/cusLogin")
    public Result cusLogin(Customer customer){
        Customer login = loginService.cusLogin(customer);
        Result result=new Result();
        if (login!=null){
            result.setCode(ISysConstants.SUCCESSCODE);
        }else{
            result.setCode(ISysConstants.ERRORCODE);
            result.setMsg("登录失败,手机号或密码错误");
        }
        return result;
    }

    /**用户注册
     * @param customer
     * @param code
     * @return
     */
    @RequestMapping("/registerCus")
    public Result registerCus(Customer customer,String code){
        int reg=loginService.registerCus(customer,code);
        Result result=new Result();
        if (reg==-1){
            result.setCode(ISysConstants.OTHERTIPS);
            result.setMsg("验证码错误");
        }else if(reg==1){
            result.setCode(ISysConstants.SUCCESSCODE);
        }else {
            result.setCode(ISysConstants.ERRORCODE);
            result.setMsg("注册失败");
        }
        return result;
    }

    /**检测手机号获取验证码
     * @param customer
     * @return
     */
    @RequestMapping("/getUsableGetPhone")
    public Result getUsableGetPhone(Customer customer){
        Customer customer1 = loginService.getUsableGetPhone(customer);
        Result result=new Result();
        if (customer1!=null){
            result.setCode(ISysConstants.ERRORCODE);
            result.setMsg("该手机号已经注册");
        }else{
            result.setCode(ISysConstants.SUCCESSCODE);
            result.setMsg("验证码已发送，请在5分钟内使用");
        }
        return result;
    }

    /**判断是否登录
     * @return
     */
    @RequestMapping("/judgeCusLogin")
    public Result judgeCusLogin(){
        Customer judgeCusLogin = loginService.judgeCusLogin();
        Result result=new Result();
        if (judgeCusLogin==null){
            result.setCode(ISysConstants.ERRORCODE);
        }else{
            result.setCode(ISysConstants.SUCCESSCODE);
            result.setObject(judgeCusLogin.getCusername());
        }
        return result;
    }

    /**
     * 销毁session退出登录
     */
    @RequestMapping("/killCusSession")
    public Result killCusSession(){
        CusUtil.removeCusson();
        return new Result(ISysConstants.SUCCESSCODE,null,null);
    }

}
