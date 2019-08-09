package com.aaa.house.dao;

import com.aaa.house.entity.Employee;
import com.aaa.house.entity.FollowHouse;
import com.aaa.house.entity.House;
import com.aaa.house.entity.HouseFurniture;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HouseMapper {
    int queryHouseCount(Map map);

    List<Map> queryHouses(Map map);

    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    /**
     * 保存家具信息
     * @param houseFurniture
     * @return
     */
    int saveFurniture(HouseFurniture houseFurniture);

    /**
     * 前台获取全部已发布的房屋列表
     */
    @Select("select h.id,h.houseid,h.htitle,h.hfloor,h.headPic,h.hadr,h.hrent,h.state,hs.name ,h.harea,h.orientation, DATE_FORMAT(h.releasedate,'%Y-%m-%d') releasedate, DATEDIFF(NOW(),h.releasedate) newstime,h.hdesc from house h,house_state hs where h.state=hs.id and h.state=6 and h.hadr like '%${hadr}%'")
    List<House> houseList(House house, RowBounds rowBounds);

    /**
     * 前台获取已发布房源列表总数
     */
    @Select("select count(1) from house where state=6 and hadr like '%${hadr}%'")
    int count(House house);

    /**
     * 前台根据房屋ID获取对应的配套设施
     */
    @Select("select f.furniturename from house h,house_furniture hf,furniture f where h.houseid=hf.houseid and hf.furnitureid=f.furnitureid and h.houseid=#{houseid}")
    List<String> houseInstallation(Integer houseid);

    /**
     * 前台根据ID获取房屋详细信息
     */
    @Select("select h.id,h.houseid,h.cnumber,h.hadr,h.agentid,h.htitle,h.hrent,h.state,h.hfloor,h.harea,h.orientation,DATE_FORMAT(h.releasedate,'%Y-%m-%d') releasedate,DATEDIFF(NOW(),h.releasedate) newstime,h.hdesc,h.headPic from house h where h.id=#{id}")
    House houseDetail(Integer id);


    /**
     * 根据ID获取经纪人信息
     */
    @Select("select * from employee where enumber=#{enumber}")
    Employee getAgentInfo(Integer enumber);

    /**
     * 关注房源
     */
    @Insert("insert into FollowHouse (cid,houseid) values (#{cid},#{houseid})")
    int followhouse(Integer cid, Integer houseid);

    /**
     * 判断是否已经关注
     */
    @Select("select * from followhouse where cid=#{cid} and houseid=#{houseid}")
    FollowHouse isFollow(Integer cid, Integer houseid);

    /**
     * 用户关注的房源
     */
    @Select("select h.id,h.houseid,h.htitle,h.hfloor,h.headPic,h.hadr,h.hrent,h.harea,h.orientation,DATE_FORMAT(h.releasedate,'%Y-%m-%d') releasedate,DATEDIFF(NOW(),h.releasedate) newstime,h.hdesc from house h,house_state hs,followhouse f where h.state=hs.id and f.houseid=h.id and h.state=6 and f.cid=#{cid}")
    List<House> myFollowHouse(Integer cid);

    /**
     * 用户关注房源的总数
     */
    @Select("select count(f.id) from house h, followhouse f where h.id=f.houseid and f.cid=#{cid}")
    int myFollowHouseCount(Integer cid);

    /**
     * 取消关注
     */
    @Delete("delete from followhouse where cid=#{cid} and houseid=#{houseid}")
    int delFollow(Integer cid, Integer houseid);

    /**
     * 后台发布的房源
     */
    @Select("select h.id,h.houseid,h.htitle,h.hfloor,h.headPic,h.hadr,h.hrent,h.harea,h.orientation,DATE_FORMAT(h.releasedate,'%Y-%m-%d') releasedate,DATEDIFF(NOW(),h.releasedate) newstime,h.hdesc from house h,house_state hs where h.state=hs.id and h.state=6 and h.cnumber=#{cnumber}")
    List<House> myPostedHouse(String cnumber);

    /**
     * 后台发布的房源总数
     */
    @Select("select count(1) from house where state=6 and cnumber=#{cnumber}")
    int myPostedHouseCount(String cnumber);

}