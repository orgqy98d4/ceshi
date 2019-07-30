package com.aaa.house.service;

import com.aaa.house.dao.CustomerDao;
import com.aaa.house.entity.Customer;
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


    @Override
    public int insert(Customer customer) {
        return customerDao.insert(customer);
    }

    @Override
    public int update(Customer customer) {
        return customerDao.update(customer);
    }

    @Override
    public int delete(Integer id) {
        return customerDao.delete(id);
    }

    @Override
    public List<Map> queryAll(Map map) {
        List<Map> list = customerDao.queryAll(map);
        return list;
    }

    @Override
    public Customer select(Integer id) {
        return customerDao.select(id);
    }

    @Override
    public int queryPageCount(Map map) {
        return customerDao.queryPageCount(map);
    }

}
