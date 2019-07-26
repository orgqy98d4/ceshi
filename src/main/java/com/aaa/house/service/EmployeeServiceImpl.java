package com.aaa.house.service;

import com.aaa.house.dao.EmployeeMapper;
import com.aaa.house.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 86187 杨金瑞
 * Date: 2019/7/25
 * Time: 21:30
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Employee record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Employee record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Employee selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Employee> queryAll(Map map) {
        return mapper.queryAll(map);
    }

    @Override
    public int queryPageCont(Map map) {
        return mapper.queryPageCont(map);
    }
}
