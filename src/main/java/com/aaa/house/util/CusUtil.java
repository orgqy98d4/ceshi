package com.aaa.house.util;

import com.aaa.house.entity.Customer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-31 15:21
 **/
public class CusUtil {

    /**
     * 取HttpServletRequest
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes att = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return att.getRequest();
    }

    /**
     * 获取session
     *
     * @return
     */
    public static HttpSession getSession() {
        HttpSession session = null;
        if (null == session) {
            session = getRequest().getSession();
        }
        return session;
    }

    /**
     * 往session中保存登录后的客户信息
     *
     * @param customer
     */
    public static void saveCus(Customer customer) {
        getSession().setAttribute(ISysConstants.CUS, customer);
    }


    /**
     * 从session获取客户信息
     *
     * @return
     */
    public static Customer getCusFromSession() {
        Customer customer = (Customer) getSession().getAttribute(ISysConstants.CUS);
        return customer;
    }

    /**
     * 退出登录，销毁session
     */
    public static void removeCusson() {
        getSession().invalidate();
    }

}
