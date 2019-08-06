package com.aaa.house.dao;

/**
 * @Local com.aaa.house.dao
 * @Author ZongKeLi
 * @Date 2019/08/04  16:00
 * @Version 1.0
 */

import com.aaa.house.entity.RoleTreeNode;
import com.aaa.house.entity.TreeNode;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色树
 */
public interface RoleTreeMapper {

    /**
     * 根据员工id获取对应的角色
     * @param eid
     * @return
     */
    @Select("select r.rid rid,r.rname rname,r.pid pid \n" +
            "from role r,role_employee re \n" +
            "where r.rid=re.rid and re.eid=#{eid}\n" +
            "order by r.pid,r.rid asc")
    List<RoleTreeNode> getRolesByEid(Integer eid);


    /**
     * 获取所有角色树
     * @return
     */
    @Select("select rid,rname label,pid from role")
    List<RoleTreeNode> getRoleTree();

    /**
     * 根据员工编号获取对应的所有角色编号
     * @param eid
     * @return
     */
    @Select("select rid from role_employee where eid=#{eid} ")
    List<Integer> getRidByEid(Integer eid);

    /**
     * 根据员工编号删除对应的所有角色
     * @param id
     * @return
     */
    @Delete("delete from role_employee where eid=#{id}")
    int deleteMenuByRid(Integer id);

    /**
     * 为员工添加角色
     * @param eid
     * @param rid
     * @return
     */
    @Insert("insert into role_employee (eid,rid) values(#{eid},#{rid})")
    int addMenu(Integer eid, Integer rid);
}
