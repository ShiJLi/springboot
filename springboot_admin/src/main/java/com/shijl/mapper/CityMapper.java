package com.shijl.mapper;


import com.shijl.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.yaml.snakeyaml.events.Event;

/**
 * @author Administrator
 */
//@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    City getById(long id);


    @Insert(" insert into city (`name`,`state`,`country`)values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveCity(City city);
}
