package com.shijl.service.impl;

import com.shijl.bean.City;
import com.shijl.mapper.CityMapper;
import com.shijl.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;


    @Override
    public City getById(long id) {
        return cityMapper.getById(id);
    }

    @Override
    public void saveCity(City city) {
        cityMapper.saveCity(city);
    }
}
