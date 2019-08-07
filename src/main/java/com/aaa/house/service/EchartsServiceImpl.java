package com.aaa.house.service;


import com.aaa.house.dao.EchartsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:EchartsService
 * description:
 * author:dyh
 * createTime:2019/8/6 10:14
 * versoin:1.0.0
 */
@Service
public class EchartsServiceImpl implements EchartsService{


    @Autowired
    private EchartsDao echartsDao;

    @Override
    public List<Map> getDataA(Map map) {
        return echartsDao.getDataA(map);
    }
}
