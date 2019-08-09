package com.aaa.house.service;

import com.aaa.house.dao.LendMoneyDao;
import com.aaa.house.entity.LendMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 86187 杨金瑞
 * Date: 2019/8/7
 * Time: 11:02
 **/
@Service
public class LendMoneyServiceImpl implements LendMoneyService {
    //自动注入
    @Autowired
    private LendMoneyDao dao;

    @Override
    public int insert(LendMoney record) {
        return dao.insert(record);
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public LendMoney queryId(Integer id) {
        return dao.queryId(id);
    }

    @Override
    public int update(LendMoney record) {
        return dao.update(record);
    }

    @Override
    public List<Map> queryAll(Map map) {
        List<Map> list=dao.queryAll(map);
        return list;
    }

    @Override
    public int queryPageCont(Map map) {
        return dao.queryPageCont(map);
    }
}
