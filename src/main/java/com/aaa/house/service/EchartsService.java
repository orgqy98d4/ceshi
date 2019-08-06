package com.aaa.house.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * fileName:EchartsService
 * description:
 * author:zz
 * createTime:2019/8/2 18:17
 * versoin:1.0.0
 */
public interface EchartsService {

    /**
     * 获取统计数据
     * @param map
     * @return
     */
    List<Map> getDataA(Map map);
}
