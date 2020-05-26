package com.flightmap.demo.Dao;

import com.flightmap.demo.Pojo.MapCountall;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MapCountallMapper {
    int deleteByPrimaryKey(Long flightDataId);

    int insert(MapCountall record);

    int insertSelective(MapCountall record);

    MapCountall selectByPrimaryKey(Long flightDataId);

    int updateByPrimaryKeySelective(MapCountall record);

    int updateByPrimaryKey(MapCountall record);

    int updateByIcao(MapCountall mapCountall);

    MapCountall selectByIcao(String icao);

    List<MapCountall> queryByRange(Double lomin, Double lamin, Double lomax, Double lamax);


    int countNumberCurrent();

    int countNumberToday();

    int insertEachFlightData(MapCountall mapCountall);

    List<MapCountall> queryEachDataByIcao(String icao);
}