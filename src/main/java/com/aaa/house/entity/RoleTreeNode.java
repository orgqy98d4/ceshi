package com.aaa.house.entity;

import lombok.Data;

import java.util.List;

/**
 * @Local com.aaa.house.entity
 * @Author ZongKeLi
 * @Date 2019/08/04  15:56
 * @Version 1.0
 */

/**
 * 角色树
 */
@Data
public class RoleTreeNode {
    private Integer rid;
    private String label;
    private Integer pid;
    private List<RoleTreeNode> children;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<RoleTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<RoleTreeNode> children) {
        this.children = children;
    }
}
