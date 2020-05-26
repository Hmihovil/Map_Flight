package com.flightmap.demo.Service;

import com.flightmap.demo.Common.ServerResponse;
import com.flightmap.demo.Pojo.MapCountall;
import java.text.ParseException;

public interface IFlightAllCountService {

    public void  flightCount() throws ParseException;

    ServerResponse<MapCountall> currentDataWorld();
}
