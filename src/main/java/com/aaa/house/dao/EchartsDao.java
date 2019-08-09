package com.aaa.house.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * fileName:EchartsDao
 * description:
 * author:dyh
 * createTime:2019/8/6 10:13:03
 * versoin:1.0.0
 */
@Repository
public interface EchartsDao {

    /**
     * 获取统计数据
     * @param map
     * @return
     */
  @Select("<script>select <if test='month!=null and month!=0'> DATE_FORMAT(c.signdate,'%m-%d') </if> <if test='month==null or month==0'> date_format(c.signdate,'%Y-%m') </if> as months,IFNULL(SUM(case when paytype=1 then lendmoney end),0) zc,IFNULL(SUM(case when paytype=2 then money end),0) sr from contract c" +
          " where DATE_FORMAT(c.signdate,'%Y')=#{year}" +
          " <if test='month!=null and month!=0'> and date_format(c.signdate,'%m')=#{month} </if>" +
          " GROUP BY  <if test='month!=null and month!=0'> date_format(c.signdate,'%m-%d') </if> <if test='month==null or month==0'> DATE_FORMAT(c.signdate,'%Y-%m')</if>" +
          " order by <if test='month!=null and month!=0'> date_format(c.signdate,'%m-%d')</if> <if test='month==null or month==0'> date_format(c.signdate,'%Y-%m')</if></script>")
    //@Select("select DATE_FORMAT(c.signdate,'%Y-%m')as months,IFNULL(SUM(case when paytype=1 then lendmoney  end),0) zc,IFNULL(SUM(case when paytype=1 or 2 then money+lendmoney  end),0) sr from contract c where DATE_FORMAT(c.signdate,'%Y-%m')=#{year} and date_format(c.signdate,'%m')=#{month} GROUP BY DATE_FORMAT(c.signdate,'%Y-%m') order by date_format(c.signdate,'%Y-%m')")
    //@Select("select DATE_FORMAT(c.signdate,'%Y-%m') as months,IFNULL(SUM(case when paytype=1 then lendmoney  end),0) zc,IFNULL(SUM(case when paytype=2 then money  end),0) sr from contract c where DATE_FORMAT(c.signdate,'%Y-%m')=#{year} GROUP BY DATE_FORMAT(c.signdate,'%Y-%m')")
    List<Map> getDataA(Map map);
}
