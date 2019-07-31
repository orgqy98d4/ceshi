package com.aaa.house.service;

import com.aaa.house.dao.HouseStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseStateServiceImpl implements HouseStateService {
    @Autowired
    private HouseStateMapper houseStateMapper;
    @Override
    public List<Map> queryStates() {
        return houseStateMapper.queryStates();
    }
}
