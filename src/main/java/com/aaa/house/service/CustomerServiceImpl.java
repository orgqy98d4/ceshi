package com.aaa.house.service;

import com.aaa.house.dao.CustomerDao;
import com.aaa.house.entity.Customer;
import com.aaa.house.util.CusUtil;
import com.aaa.house.util.OtherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-26 10:47
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 添加客户
     * */
    @Override
    public int insert(Customer customer) {
        customer.setCnumber(OtherUtil.GetCnum());
        customer.setCusername(OtherUtil.getUname());
        customer.setCpassword(OtherUtil.MD5("000000"));
        return customerDao.insert(customer);
    }

    /**
     * 修改客户
     * */
    @Override
    public int update(Customer customer) {
        return customerDao.update(customer);
    }

    /**
     * 删除客户
     * */
    @Override
    public int delete(Integer id) {
        return customerDao.delete(id);
    }

    /**
     * 查询全部客户
     * */
    @Override
    public List<Map> queryAll(Map map) {
        List<Map> list = customerDao.queryAll(map);
        return list;
    }

    /**
     * 查询单个客户
     * */
    @Override
    public Customer select(Integer id) {
        return customerDao.select(id);
    }

    /**
     * 查询分页总数量
     * */
    @Override
    public int queryPageCount(Map map) {
        return customerDao.queryPageCount(map);
    }

    /**
     * 个人中心
     * 从Session中取出用户信息
     */
    @Override
    public Customer getCusFromSession() {
        return CusUtil.getCusFromSession();
    }

}
