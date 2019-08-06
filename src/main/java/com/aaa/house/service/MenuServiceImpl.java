package com.aaa.house.service;

import com.aaa.house.dao.MenuMapper;
import com.aaa.house.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Local com.aaa.house.service
 * @Author ZongKeLi
 * @Date 2019/07/30  19:49
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public int deleteByPrimaryKey(Integer mid) {
        return menuMapper.deleteByPrimaryKey(mid);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Integer mid) {
        return menuMapper.selectByPrimaryKey(mid);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }

    /**
     * 权限列表
     * @return
     */
    @Override
    public List<Map> queryAll(Map map) {
        return menuMapper.queryAll(map);
    }

    /**
     * 查询出来总数量
     * @param map
     * @return
     */
    @Override
    public int queryPageCont(Map map) {
        return menuMapper.queryPageCont(map);
    }

    /**
     * 获取所有的父级菜单
     * @return
     */
    @Override
    public List<Map> getFatherMenu(Map map) {
        return menuMapper.getFatherMenu(map);
    }

    /**
     * 获取父菜单数量
     * @return
     */
    @Override
    public int queryFatherCount(Map map) {
        return menuMapper.queryFatherCount(map);
    }

    /**
     * 添加父菜单
     * @param menu
     * @return
     */
    @Override
    public int addFatherMenu(Menu menu) {
        return menuMapper.addFatherMenu(menu);
    }

    /**
     * 更新父菜单
     * @param menu
     * @return
     */
    @Override
    public int updateFatherMenu(Menu menu) {
        return menuMapper.updateFatherMenu(menu);
    }

    /**
     * 删除父菜单及其子菜单
     * @param mid
     * @return
     */
    @Override
    public int deleteFatherMenu(Integer mid) {
        return menuMapper.deleteFatherMenu(mid);
    }

    /**
     * 获取所有的子菜单
     * @return
     */
    @Override
    public List<Map> getSonMenu(Map map) {
        return menuMapper.getSonMenu(map);
    }

    /**
     * 获取子菜单的数量
     * @return
     */
    @Override
    public int getSonMenuCount(Map map) {
        return menuMapper.getSonMenuCount(map);
    }

    /**
     * 添加子菜单
     * @param menu
     * @return
     */
    @Override
    public int addSonMenu(Menu menu) {
        return menuMapper.addSonMenu(menu);
    }

    /**
     * 修改子菜单
     * @param menu
     * @return
     */
    @Override
    public int updateSonMenu(Menu menu) {
        return menuMapper.updateSonMenu(menu);
    }

    /**
     * 删除子菜单
     * @param mid
     * @return
     */
    @Override
    public int deleteSonMenu(Integer mid) {
        return menuMapper.deleteSonMenu(mid);
    }
}
