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
    @Select("<script>select <if test='month!=null and month!=0'> date_format(t.operator_time,'%m-%d') </if>  <if test='month==null or month==0'> date_format(t.operator_time,'%Y-%m') </if> as months,ifnull(sum(case when pay_type='还款' then pay_money end),0) hk,ifnull(sum(case when pay_type='放款' then pay_money end),0) fk from mingxi t " +
            "where  date_format(t.operator_time,'%Y')=#{year}" +
            "<if test='month!=null and month!=0'> and date_format(t.operator_time, '%m')=#{month} </if>"+
            " group by <if test='month!=null and month!=0'> date_format(t.operator_time,'%m-%d') </if>  <if test='month==null or month==0'> date_format(t.operator_time,'%Y-%m')</if>" +
            " order by  <if test='month!=null and month!=0'> date_format(t.operator_time,'%m-%d') </if>  <if test='month==null or month==0'> date_format(t.operator_time,'%Y-%m')</if></script>")
    List<Map> getDataA(Map map);
}
