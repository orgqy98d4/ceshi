package com.aaa.house.service;

import com.aaa.house.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-26 10:14
 **/

public interface CustomerService {

    /**
     * 添加客户
     * */
    int insert(Customer customer);

    /**
     * 修改客户
     * */
    int update(Customer customer);

    /**
     * 删除客户
     * */
    int delete(Integer id);

    /**
     * 查询全部客户
     * */
    List<Map> queryAll(Map map);

    /**
     * 查询单个客户
     * */
    Customer select(Integer id);

    /**
     * 查询分页总数量
     * */
    int queryPageCount(Map map);

    /**
     * 个人中心
     * 从Session中取出用户信息
     */
     Customer getCusFromSession();

}
