package com.aaa.house.dao;

import com.aaa.house.entity.Menu;
import com.aaa.house.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
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
    List<Map> queryAll(Map map);

    /**
     * 查询出来所有权限的总数量
     * @param map
     * @return
     */
    int queryPageCont(Map map);

    /**
     * 获取所有的父级菜单
     * @return
     */
    List<Map> getFatherMenu(Map map);

    /**
     * 获取父级菜单的数量
     */
    int queryFatherCount(Map map);

    /**
     * 添加父菜单
     * @param menu
     * @return
     */
    @Insert("insert into menu (mname,pid,mdesc) values(#{mname},0,#{mdesc})")
    int addFatherMenu(Menu menu);

    /**
     * 修改父菜单内容
     * @param menu
     * @return
     */
    @Update("update menu set mname=#{mname},mdesc=#{mdesc} where mid=#{mid}")
    int updateFatherMenu(Menu menu);

    /**
     * 删除父菜单及其子菜单
     * @param mid
     * @return
     */
    @Delete("delete from menu where mid=#{mid} or pid=#{mid}")
    int deleteFatherMenu(Integer mid);

    /**
     * 获取所有的子菜单
     * @return
     */
    List<Map> getSonMenu(Map map);

    /**
     * 获取子菜单的条数
     *
     */
    int getSonMenuCount(Map map);

    /**
     * 添加子菜单
     * @param menu
     * @return
     */
    @Insert("insert into menu (mname,pid,mdesc) values(#{mname},#{pid},#{mdesc})")
    int addSonMenu(Menu menu);

    /**
     * 修改子菜单
     * @param menu
     * @return
     */
    @Update("update menu set mname=#{mname},pid=#{pid},mdesc=#{mdesc} where mid=#{mid}")
    int updateSonMenu(Menu menu);

    /**
     * 删除子菜单
     * @param mid
     * @return
     */
    @Delete("delete from menu where mid=#{mid}")
    int deleteSonMenu(Integer mid);
}