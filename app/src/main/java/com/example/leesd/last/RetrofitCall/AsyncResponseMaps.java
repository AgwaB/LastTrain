package com.example.leesd.last.RetrofitCall;


import com.example.leesd.last.GetArrInfoByRouteList.RouteListMainInfo;
import com.example.leesd.last.GetRouteByStationList.StationListMainInfo;
import com.example.leesd.last.GetStaionByRoute.RouteMainInfo;
import com.example.leesd.last.GetStationByPos.PosMainInfo;
import com.example.leesd.last.googlemaps.JsonMaps;

import retrofit2.Response;

/**
 * Created by leo on 2017-07-17.
 */

// interface for getting response in activity
public interface AsyncResponseMaps {
    void processFinish(Response<JsonMaps> response); // call if Retrofit is finished
    void PosProcessFinish(Response<PosMainInfo> response);
    void RouteProcessFinish(Response<RouteMainInfo> response);
    void RouteListProcessFinish(Response<RouteListMainInfo> response);
    void StationListProcessFinish(Response<StationListMainInfo> response);
}
