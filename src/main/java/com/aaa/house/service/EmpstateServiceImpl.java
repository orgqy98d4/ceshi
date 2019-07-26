package com.aaa.house.service;

import com.aaa.house.dao.EmpstateMapper;
import com.aaa.house.entity.Empstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 86187 杨金瑞
 * Date: 2019/7/25
 * Time: 21:34
 **/
@Service
public class EmpstateServiceImpl implements EmpstateService {
    @Autowired
    private EmpstateMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Empstate record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Empstate record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Empstate selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Empstate record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Empstate record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Empstate> queryState() {
        return mapper.queryState();
    }
}
