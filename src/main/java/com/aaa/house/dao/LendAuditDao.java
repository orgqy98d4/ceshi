package com.aaa.house.dao;



import com.aaa.house.entity.HouseContract;
import com.aaa.house.entity.LendAudit;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendAuditDao {

    /**
     * 查询出来所有的内容
     */
    @Select("SELECT * from lend_audit")
    List<LendAudit> queryAudit();


    /**
     * 查询出来所有的 合同表的内容
     */
    @Select("SELECT * from contract where contractid=#{contractid}")
    List<HouseContract> queryCon(Integer contractid);

}
