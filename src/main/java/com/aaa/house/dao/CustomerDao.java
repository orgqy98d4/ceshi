package com.aaa.house.dao;

import com.aaa.house.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-26 10:14
 **/

@Repository
public interface CustomerDao {

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

}
