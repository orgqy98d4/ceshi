package com.aaa.house.dao;

import com.aaa.house.entity.Cusstate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-29 10:00
 **/
@Repository
public interface CusstateDao {
    /**
     * 查询客户状态
     * */
    List<Cusstate> queryState();

}
