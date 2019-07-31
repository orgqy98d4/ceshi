package com.aaa.house.service;

import com.aaa.house.dao.CustypeDao;
import com.aaa.house.entity.Custype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: house_rentd4
 * @description:
 * @author: WGY
 * @create: 2019-07-29 10:07
 **/
@Service
public class CustypeServiceImpl implements CustypeService {

    @Autowired
    private CustypeDao custypeDao;

    @Override
    public List<Custype> queryType() {
        return custypeDao.queryType();
    }
}
