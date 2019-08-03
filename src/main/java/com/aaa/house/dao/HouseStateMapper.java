package com.aaa.house.dao;

import com.aaa.house.entity.HouseState;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HouseStateMapper {

    /**
     * 获取状态集合列表
     * @return
     */
    List<Map> queryStates();

    /**
     * 只查询出一条状态，即待审核，id为2
     * @return
     */
    List<Map> queryState2();

    /**
     * 获取经纪人列表
     * @return
     */
    List<Map> queryAgents();

    /**
     * 查询出所有待审核的房源
     * @return
     */
    @Select("select h.*, hs.name  from house h join house_state hs on h.state=hs.id where h.state=2")
    List<Map> queryUnchecked();

    /**
     * 修改待审核的房源状态为已审核
     * @return
     */
    @Update("update house set state=4 where state=2 and houseid=#{houseid}")
    int updateUnchecked(int houseid);

    /**
     * 查询出所有已出租的房源
     * @return
     */
    @Select("select h.*, hs.name  from house h join house_state hs on h.state=hs.id where h.state=5")
    List<Map> queryRented();

}