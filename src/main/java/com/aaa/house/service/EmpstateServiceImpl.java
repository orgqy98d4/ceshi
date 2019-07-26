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

    /**
     * 查询出来员工在职状态
     * @return
     */
    @Override
    public List<Empstate> queryState() {
        return mapper.queryState();
    }
}
