package com.aaa.house.service;

import com.aaa.house.dao.HouseFurnitureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseFurnitureServiceImpl implements HouseFurnitureService {
    @Autowired
    private HouseFurnitureDao furnitureDao;
    @Override
    public List<Map> queryFurnitures() {
        return furnitureDao.queryFurnitures();
    }
}
