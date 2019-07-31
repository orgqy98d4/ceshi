package com.aaa.house.service;

import com.aaa.house.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Local com.aaa.house.service
 * @Author ZongKeLi
 * @Date 2019/07/30  19:48
 * @Version 1.0
 */
public interface MenuService {
    /**
     * 删除
     * @param mid
     * @return
     */
    int deleteByPrimaryKey(Integer mid);
    /**
     * 录入
     * @param record
     * @return
     */
    int insert(Menu record);
    /**
     * 动态sql录入
     * @param record
     * @return
     */
    int insertSelective(Menu record);
    /**
     * 根据主键查询
     * @param mid
     * @return
     */
    Menu selectByPrimaryKey(Integer mid);
    /**
     * 动态更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Menu record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Menu record);

    /**
     * 权限列表
     * @return
     */
    List<Menu> queryAll();
}
