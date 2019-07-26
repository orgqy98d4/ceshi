package com.aaa.house.shiroconfig;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Local com.aaa.house.shiroconfig
 * @Author ZongKeLi
 * @Date 2019/07/25  20:52
 * @Version 1.0
 */
//对原始密码进行加密
@Component
public class PasswordHelper {
    //定义加密算法的名称  hash：散列  Algorithm：算法
    private String hashAlgorithmName="MD5";
    //定义迭代的次数
    private Integer  hashIterations=1024;
    //对原始密码的加密方法
    public void encryptPassword(Map map){
        //获取原始密码
        String password=map.get("epassword")+"";
        //获取盐
        ByteSource credentialsSalt = ByteSource.Util.bytes(map.get("eusername"));
        //对原始密码进行加密
        String credentials= new SimpleHash(hashAlgorithmName, password, credentialsSalt, hashIterations).toHex();
        //将加密后的密码赋值给User对象
        map.put("credentials",credentials);
    }
}
