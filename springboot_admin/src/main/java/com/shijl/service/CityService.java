package com.shijl.service;

import com.shijl.bean.City;

public interface CityService {


    City getById(long id);

    void saveCity(City city);

}
