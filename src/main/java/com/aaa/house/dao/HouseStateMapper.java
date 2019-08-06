package com.aaa.house.dao;

import com.aaa.house.entity.House;
import com.aaa.house.entity.HouseContract;
import com.aaa.house.entity.HouseState;
import org.apache.ibatis.annotations.Insert;
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
//    @Select("select h.*, hs.name  from house h join house_state hs on h.state=hs.id where h.state=2")
    List<Map> queryUnchecked(Map map);
    //查询出所有待审核的房源数量
    int uncheckedCount(Map map);

    /**
     * 修改待审核的房源状态为已审核
     * @return
     */
    @Update("update house set state=4 where state=2 and houseid=#{houseid}")
    int updateUnchecked(int houseid);


    /**
     * 向房东表中添加一条信息
     * @param house
     * @return
     */
    int addHost(House house);
    /**
     * 根据房东姓名获取该房东对应的编号id
     * @param cname
     * @return
     */
    @Select("select id from customer where cname=#{cname}")
    int getIdByCname(String cname);

    /**
     * 获取到房屋编号后为相应的房屋设置房东编号
     * @param id
     * @param houseid
     * @return
     */
    @Update("update house set landlord=#{id} where houseid=#{houseid}")
    int setHostId(Integer id,Integer houseid);
    /**
     * 根据编号，书写驳回理由
     * @param house
     * @return
     */
    @Update("update house set rejectReason=#{rejectReason},state=3 where houseid=#{houseid}")
    int setRejectReason(House house);

    /**
     * 查询出所有已审核待发布的房源
     * @return
     */
//    @Select("select h.*, hs.name  from house h join house_state hs on h.state=hs.id where h.state=4 limit #{start},#{pageSize}")
    List<Map> queryChecked(Map map);
     //查询所有已审核待发布的数量
    int checkedCount(Map map);

    /**
     * 修改待审核的房源状态为已发布
     * @return
     */
    @Update("update house set state=6 where state=4 and houseid=#{houseid}")
    int updateChecked(int houseid);


     //查询出所有已发布的房源
    List<Map> queryReleased(Map map);
    //查询所有已发布的数量
    int releasedCount(Map map);

     //查询出所有已出租的房源
     //@Select("select h.*, hs.name  from house h join house_state hs on h.state=hs.id where h.state=5")
    List<Map> queryRented(Map map);
    //查询所有已出租的数量
    int rentedCount(Map map);

    /**
     * 添加合同信息
     * @param houseContract
     * @return
     */
    int addContract(HouseContract houseContract);
    /**
     * 签订合同后将对应的房屋状态改为已出租
     */
    @Update("update house set state=5 where state=6 and houseid=#{houseid}")
    int beRented(int houseid);
}