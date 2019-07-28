package com.aaa.house.dao;

import com.aaa.house.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeMapper {
    //根据id进行删除员工账号
    int deleteByPrimaryKey(Integer id);
    //添加员工
    int insert(Employee record);
    //动态添加员工
    int insertSelective(Employee record);
    //根据id进行查询
    Employee selectByPrimaryKey(Integer id);
    //动态更新员工数据
    int updateByPrimaryKeySelective(Employee record);
    //更新员工数据
    int updateByPrimaryKey(Employee record);

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Map> queryAll(Map map);

    /**
     * 查询出来总数量
     * @param map
     * @return
     */
    int queryPageCont(Map map);
}