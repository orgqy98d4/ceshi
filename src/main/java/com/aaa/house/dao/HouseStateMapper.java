package com.aaa.house.dao;

import com.aaa.house.entity.HouseState;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HouseStateMapper {

    List<Map> queryStates();

}