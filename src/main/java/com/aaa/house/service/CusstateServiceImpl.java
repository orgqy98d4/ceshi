package com.aaa.house.service;

import com.aaa.house.dao.CusstateDao;
import com.aaa.house.entity.Cusstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-29 10:06
 **/
@Service
public class CusstateServiceImpl implements CusstateService {

    @Autowired
    private CusstateDao cusstateDao;

    @Override
    public List<Cusstate> queryState() {
        return cusstateDao.queryState();
    }
}
