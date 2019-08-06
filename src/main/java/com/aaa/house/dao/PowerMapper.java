package com.aaa.house.dao;

/**
 * @Local com.aaa.house.dao
 * @Author ZongKeLi
 * @Date 2019/08/04  16:00
 * @Version 1.0
 */

import com.aaa.house.entity.TreeNode;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限树
 */
public interface PowerMapper {


    /**
     * 根据员工id获取对应的权限
     * @param id
     * @return
     */
    @Select("select m.mid mid,m.mname label,m.url url,m.pid pid\n" +
            "from menu m,role_menu rm,employee e\n" +
            "where m.mid=rm.mid and rm.rid=e.roleid and e.id=#{id}\n" +
            "order by m.mid,m.mid asc")
    List<TreeNode> getPowersById(Integer id);


    /**
     * 获取所有权限
     * @return
     */
    @Select("select mid,mname label,pid,url from menu")
    List<TreeNode> getPowers();

    /**
     * 根据角色编号获取对应的所有权限编号
     * @param rid
     * @return
     */
    @Select("select mid from role_menu where rid=#{rid} ")
    List<Integer> getMidByRid(Integer rid);

    /**
     * 根据角色编号删除对应的所有权限
     * @param rid
     * @return
     */
    @Delete("delete from role_menu where rid=#{rid}")
    int deleteMenuByRid(Integer rid);

    /**
     * 为角色添加权限
     * @param rid
     * @param mid
     * @return
     */
    @Insert("insert into role_menu (rid,mid) values(#{rid},#{mid})")
    int addMenu(Integer rid,Integer mid);
}
