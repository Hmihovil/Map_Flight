package com.flightmap.demo.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.flightmap.demo.Common.ServerResponse;
import com.flightmap.demo.Dao.MapCountallMapper;
import com.flightmap.demo.Pojo.MapCountall;
import com.flightmap.demo.Service.IAllFlightQueryService;
import com.flightmap.demo.Service.IFlightAllCountService;
import com.flightmap.demo.Util.postSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;


@Service("iAllFlightQueryService")
public class AllFlightQueryServiceImpl implements IAllFlightQueryService {

    @Autowired
    private MapCountallMapper mapCountallMapper;


    @Override
    public ServerResponse<JSONArray> queryByRange(Double lomin, Double lamin,Double lomax, Double lamax) {
        List<MapCountall> list= mapCountallMapper.queryByRange(lomin,lamin,lomax,lamax);
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
        return ServerResponse.createBySuccess("查询成功",array);
    }


    @Override
    public ServerResponse<Object> toNumber() {
        int NumberCurrent = mapCountallMapper.countNumberCurrent();
        int NumberToday = mapCountallMapper.countNumberToday();
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("NumberToday",NumberToday);
        hashMap.put("NumberCurrent",NumberCurrent);

        Object  result = JSONObject.toJSON(hashMap);//toJSonString 会有反斜杠

        return ServerResponse.createBySuccess(result);
    }


    @Override
    public ServerResponse<JSONArray> eachDataByIcao (String icao) {

        List<MapCountall> list = mapCountallMapper.queryEachDataByIcao( icao);
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
        return ServerResponse.createBySuccess("查询成功",array);

    }





}