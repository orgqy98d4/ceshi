package com.aaa.house.service;

import com.aaa.house.dao.CustomerDao;
import com.aaa.house.entity.Customer;
import com.aaa.house.util.CusUtil;
import com.aaa.house.util.OtherUtil;
import com.aaa.house.util.SmsUtil;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-31 15:04
 **/
@Service
public class LoginServiceImpl implements LoginService {

    Customer cussession=null;   //用户名
    String codenum=null;        //手机验证码

    @Autowired
    private CustomerDao customerDao;

    /**
     * 登录
     *
     * @param customer
     * @return
     */
    @Override
    public Customer cusLogin(Customer customer) {
        customer.setCpassword(OtherUtil.MD5(customer.getCpassword()));
        Customer login = customerDao.cusLogin(customer);
        if (login!=null){
            CusUtil.saveCus(login);
            return login;
        }
        return null;
    }

    /**
     * 用户注册
     * @param customer
     * @return
     */
    @Override
    public int registerCus(Customer customer, String code) {
        System.out.println("验证的code"+code);
        if (code.equals(codenum)){
            if (OtherUtil.isEmpty(customer.getId())){
                customer.setCnumber(OtherUtil.GetCnum());
                customer.setCpassword(OtherUtil.MD5(customer.getCpassword()));
                customer.setCusername(OtherUtil.getUname());
                customerDao.registerCus(customer);
                return 1;
            }else {
                return -1;
            }
        }
        return 0;
    }

    /**检测手机号获取验证码
     * @param customer
     * @return
     */
    @Override
    public Customer getUsableGetPhone(Customer customer) {
        Customer customer1= customerDao.getUsableGetPhone(customer);
        if (customer1!=null){
            return customer1;
        }

        String telephone=customer.getCphone();
        codenum=OtherUtil.getNum();
        //System.out.println("发送的验证码"+codenum);
        try {
            SendSmsResponse sms = SmsUtil.sendSms(telephone,codenum);
            /*System.out.println("Code=" + sms.getCode());
            System.out.println("Message=" + sms.getMessage());
            System.out.println("RequestId=" + sms.getRequestId());
            System.out.println("BizId=" + sms.getBizId());*/
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断是否登录
     * @return
     */
    @Override
    public Customer judgeCusLogin() {
        cussession=CusUtil.getCusFromSession();
        if(cussession==null){
            return null;
        }
        return cussession;
    }
}
