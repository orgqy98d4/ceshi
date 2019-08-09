package com.aaa.house.service;



import com.aaa.house.entity.HouseContract;
import com.aaa.house.entity.LendAudit;

import java.util.List;

public interface LendAuditService {
    /**
     * 查询出来所有的内容
     */
    List<LendAudit> queryAudit();

    /**
     * 查询出来所有的 合同表的内容
     * @return
     */
    List<HouseContract> queryCon(Integer contractid);
}
