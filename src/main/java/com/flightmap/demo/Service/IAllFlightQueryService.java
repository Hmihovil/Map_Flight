package com.flightmap.demo.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flightmap.demo.Common.ServerResponse;

public interface IAllFlightQueryService {
    ServerResponse<JSONArray> queryByRange(Double lomin, Double lamin,Double lomax, Double lamax);

    ServerResponse<Object> toNumber();

    ServerResponse<JSONArray> eachDataByIcao(String icao);
}
