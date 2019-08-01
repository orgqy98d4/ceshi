package com.aaa.house.service;

import com.aaa.house.entity.Customer;

public interface LoginService {

    /**
     * 登录
     * */
    Customer cusLogin(Customer customer);

    /**
     * 用户注册
     */
    int registerCus(Customer customer,String code);

    /**
     * 检测手机号获取验证码
     * */
    Customer getUsableGetPhone(Customer customer);

    /**
     * 判断是否登录
     * */
    Customer judgeCusLogin();

}
