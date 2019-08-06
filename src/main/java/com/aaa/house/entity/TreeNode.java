package com.aaa.house.entity;

import lombok.Data;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

/**
 * @Local com.aaa.house.entity
 * @Author ZongKeLi
 * @Date 2019/08/04  15:56
 * @Version 1.0
 */

/**
 * 权限树
 */
@Data
public class TreeNode {
    private Integer mid;
    private String label;
    private Integer pid;
    private List<TreeNode> children;
    private String url;

    @Override
    public String toString() {
        return "TreeNode{" +
                "mid=" + mid +
                ", label='" + label + '\'' +
                ", pid=" + pid +
                ", children=" + children +
                ", url='" + url + '\'' +
                '}';
    }
}
