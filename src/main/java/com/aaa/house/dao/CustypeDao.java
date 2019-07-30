package com.aaa.house.dao;

import com.aaa.house.entity.Custype;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-29 10:01
 **/
@Repository
public interface CustypeDao {
    /**
     * 查询客户类型
     * */
    List<Custype> queryType();
}
