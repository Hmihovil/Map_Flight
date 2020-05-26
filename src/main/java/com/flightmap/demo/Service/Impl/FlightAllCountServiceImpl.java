package com.flightmap.demo.Service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flightmap.demo.Dao.EachFlightDataMapper;
import com.flightmap.demo.Dao.MapCountallMapper;
import com.flightmap.demo.Pojo.MapCountall;
import com.flightmap.demo.Service.IFlightAllCountService;
import com.flightmap.demo.Util.postSend;
import com.flightmap.demo.Common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service("iFlightAllCountService")
public class FlightAllCountServiceImpl implements IFlightAllCountService {

    @Autowired
    private MapCountallMapper mapCountallMapper;


    @Scheduled(fixedDelay = 2000)
    @Override
    public void flightCount() throws ParseException {
        System.out.println("查询开始");
        String uriString = "https://api.ifengge.cn/adsb/live/?";
        postSend postSendUtil = new postSend();
        Date queryDate = dateCurrent();
        //北半球拆分查询 防止超过1500
        JSONArray jsonArrayNorth = postSendUtil.postSend1(uriFactory(uriString, 0, 40, -180, 180));
        JSONArray jsonArrayNorth1 = postSendUtil.postSend1(uriFactory(uriString, 40, 90, -180, 180));
        int northCount = jsonArrayNorth.size() + jsonArrayNorth1.size();
        JSONArray jsonArraySouth = postSendUtil.postSend1(uriFactory(uriString, -90, 0, -180, 180));
        JSONArray jsonArrayAllCurrent1 = new JSONArray();
        jsonArrayAllCurrent1.add(jsonArrayNorth);
        jsonArrayAllCurrent1.add(jsonArrayNorth1);
        jsonArrayAllCurrent1.add(jsonArraySouth);
        //出去jsonArray中多余的[]
        String str1 = jsonArrayAllCurrent1.toString();
        str1 = JsonDataFactory(str1);
        JSONArray jsonArrayAllCurrent = JSONArray.parseArray(str1);


        for (int i = 0; i < jsonArrayAllCurrent.size(); i++) {
            JSONObject jo=new JSONObject();
            if(jsonArrayAllCurrent.getJSONObject(i).get("icao")==null){
                continue;
            }
            MapCountall mapCountall = new MapCountall(
                    (String)jsonArrayAllCurrent.getJSONObject(i).get("icao"),
                    (String)jsonArrayAllCurrent.getJSONObject(i).get("cid"),
                    (String)jsonArrayAllCurrent.getJSONObject(i).get("n"),
                    Double.parseDouble(jsonArrayAllCurrent.getJSONObject(i).get("lo").toString()),
                    Double.parseDouble(jsonArrayAllCurrent.getJSONObject(i).get("la").toString()),
                    (Integer)jsonArrayAllCurrent.getJSONObject(i).get("ang"),
                    (Integer)jsonArrayAllCurrent.getJSONObject(i).get("alt"),
                    (Integer)jsonArrayAllCurrent.getJSONObject(i).get("gs"),
                    (String)jsonArrayAllCurrent.getJSONObject(i).get("tc"),
                    (Integer)jsonArrayAllCurrent.getJSONObject(i).get("t"),
                    (String)jsonArrayAllCurrent.getJSONObject(i).get("mod"),
                    (String)jsonArrayAllCurrent.getJSONObject(i).get("dep"),
                    (String)jsonArrayAllCurrent.getJSONObject(i).get("arr"));
            mapCountallMapper.insertEachFlightData(mapCountall);
            if(mapCountallMapper.selectByIcao(mapCountall.getIcao())!=null){
                mapCountall.setUpdateTime(queryDate);
                mapCountallMapper.updateByIcao(mapCountall);
            }else {
            try {
                mapCountall.setUpdateTime(queryDate);
                mapCountall.setCreateTime(queryDate);
                mapCountallMapper.insert(mapCountall);
            }catch (Exception e){
                System.out.println("异常");
            }
            }
        }
    }



    //生成请求的url
    private URI uriFactory(String uriString, double lamin, double lamax, double lomin, double lomax) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(
                uriString + "lamin=" + lamin + "&lamax=" + lamax + "&lomin=" + lomin + "&lomax=" + lomax)
                .build()
                .encode();
        return uriComponents.toUri();
    }


    public Date dateCurrent() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        return sdf.parse(sdf.format(date));
    }


    public String JsonDataFactory(String str){
        str=str.replace("[", "");
        str=str.replace("]", "");
        str="["+str+"]";
        return str;
    }


    @Override
    public ServerResponse<MapCountall> currentDataWorld() {
        return null;
    }
//    @Override
//    public ServerResponse<MapCountall> currentDataWorld()  {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//        String dateToday = df.format(new Date());
//        MapCountall mapCountall = mapCountallMapper.selectByTime(dateToday);
//        return ServerResponse.createBySuccess("查找成功", mapCountall);
//    }
}
