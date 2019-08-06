package com.aaa.house.dao;

import com.aaa.house.entity.House;
import com.aaa.house.entity.HouseFurniture;
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
    @Select("select f.furniturename from house h,house_furniture hf,furniture f " +
            "where h.houseid=hf.houseid and hf.furnitureid=f.furnitureid " +
            "and h.houseid=#{houseid}")
    List<String> houseInstallation(Integer houseid);

}