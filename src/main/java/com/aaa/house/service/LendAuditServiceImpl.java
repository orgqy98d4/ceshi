package com.aaa.house.service;

import com.aaa.house.dao.LendAuditDao;
import com.aaa.house.entity.HouseContract;
import com.aaa.house.entity.LendAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 86187 杨金瑞
 * Date: 2019/8/7
 * Time: 11:06
 **/
@Service
public class LendAuditServiceImpl implements LendAuditService {
    //自动注入
    @Autowired
    private LendAuditDao dao;

    /**
     * 查询出来所有的内容
     * @return
     */
    @Override
    public List<LendAudit> queryAudit() {
        return dao.queryAudit();
    }

    /**
     * 查询出来所有的合同编号
     * @return
     */
    @Override
    public List<HouseContract> queryCon(Integer contractid) {
        return dao.queryCon(contractid);
    }
}
