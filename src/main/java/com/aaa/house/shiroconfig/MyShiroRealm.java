package com.aaa.house.shiroconfig;


import com.aaa.house.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Local com.aaa.house.shiroconfig
 * @Author ZongKeLi
 * @Date 2019/07/25  11:08
 * @Version 1.0
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    EmployeeService employeeService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始进行登录认证");
        //从登录页面获取登录信息
         UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        Session session = SecurityUtils.getSubject().getSession();
         //获取登录的用户名
        String username = usernamePasswordToken.getUsername();
        System.out.println("登录的账号："+username);
        //声明一个Emp对象
        Map emp=null;
        //声明临时map
        Map map=new HashMap();
        map.put("eusername",username);
        map.put("start",0);
        map.put("pageSize",100);
        //从数据库查找username对应的对象
        List<Map> maps = employeeService.queryAll(map);
        if (maps!=null&&maps.size()>0){
            emp=maps.get(0);
        }
        if(emp==null) {
            throw new UnknownAccountException("用户不存在");
        }
        //当验证信息都通过后，把用户信息放在session里
        session.setAttribute("emp",emp);
        //对密码进行加密处理
        new PasswordHelper().encryptPassword(emp);
        //获取加密后的密码
        String credentials = emp.get("credentials")+"";
        System.out.println("加密后的密码"+credentials);
        //获取盐
        ByteSource source = ByteSource.Util.bytes(username);
        //构建AuthenticationInfo对象（封装的是数据库中的账号及加密后的密码）
        AuthenticationInfo info=new SimpleAuthenticationInfo(emp.get("eusername"),credentials,source,getName());
        return info;
    }
}
