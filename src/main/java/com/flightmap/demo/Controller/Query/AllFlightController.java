package com.flightmap.demo.Controller.Query;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.flightmap.demo.Common.CustomException.TransactionException;
import com.flightmap.demo.Common.ServerResponse;
import com.flightmap.demo.Service.IAllFlightQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/query/")
public class AllFlightController {

    @Autowired
    private IAllFlightQueryService iAllFlightQueryService;



     /**
         * 范围飞机查询(通过经纬度）
         * @return ServerResponse<JSONArray>
         */
    @RequestMapping(value = "byRange",method = RequestMethod.POST)
    @ResponseBody //序列化为json
    public ServerResponse<JSONArray> queryByRange(Double lomin, Double lamin,Double lomax, Double lamax ) throws TransactionException {
        return iAllFlightQueryService.queryByRange( lomin , lamin,lomax,lamax  );
        }

    /**
     * 飞机数量查询(通过经纬度）
     * @return ServerResponse<JSONArray>
     */
    @RequestMapping(value = "toNumber",method = RequestMethod.POST)
    @ResponseBody //序列化为json
    public ServerResponse<Object> toNumber() throws TransactionException {
        return iAllFlightQueryService.toNumber();
    }

    /**
     * 飞机轨迹查询(通过icao）
     * @return ServerResponse<JSONArray>
     */
    @RequestMapping(value = "eachDataByIcao",method = RequestMethod.POST)
    @ResponseBody //序列化为json
    public ServerResponse<JSONArray> eachDataByIcao(String icao) throws TransactionException {
        return iAllFlightQueryService.eachDataByIcao(icao);
    }


}

