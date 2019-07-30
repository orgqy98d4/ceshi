package com.aaa.house.shiroconfig;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Local com.aaa.house.shiroconfig
 * @Author ZongKeLi
 * @Date 2019/07/25  11:05
 * @Version 1.0
 */
@Configuration
public class ShiroConfiguration {

    /**
     * 引入编写的myRealm
     * @return
     */
    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm=new MyShiroRealm();
        //将加密算法注入myShiroRealm
        myShiroRealm.setCredentialsMatcher(credentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 陪配加密算法
     * @return
     */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    /**
     * 安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }


    /**
     * Filter工厂（shiro过滤器），设置过滤条件和跳转条件
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map=new LinkedHashMap<>();

        //验证token
        map.put("/checkToken", "anon");
        //可以匿名访问的地址
        //注销
        map.put("/logout","logout");
        //登录的请求地址，可以直接访问
        map.put("/login","anon");
        //静态资源直接访问
        map.put("/img/**","anon");
        //首页直接访问
        map.put("/index.html","anon");
        //对所有请求进行认证
        map.put("/**","authc");
        //登录页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //登录成功跳转页面
        shiroFilterFactoryBean.setSuccessUrl("/employee/list.html");
        //错误页面，认证不通过跳转页面(未授权)
        shiroFilterFactoryBean.setUnauthorizedUrl("/error.html");
        //将配置的map放进FilterChainDefinitionMap中
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

}



















