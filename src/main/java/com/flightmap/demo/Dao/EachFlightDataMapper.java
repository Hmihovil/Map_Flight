package com.flightmap.demo.Dao;

import com.flightmap.demo.Pojo.EachFlightData;
import com.flightmap.demo.Pojo.MapCountall;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EachFlightDataMapper {
    int deleteByPrimaryKey(Long flightDataId);

    int insert(EachFlightData record);
    int insert(MapCountall record);
    int insertSelective(EachFlightData record);

    EachFlightData selectByPrimaryKey(Long flightDataId);

    int updateByPrimaryKeySelective(EachFlightData record);

    int updateByPrimaryKey(EachFlightData record);
}