package com.example.leesd.last.RetrofitCall;

import com.example.leesd.last.GetArrInfoByRouteList.RouteListMainInfo;
import com.example.leesd.last.GetStationByPos.PosMainInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by leesd on 2018-04-08.
 */

public interface DataServiceRouteList { // 도착 정보

    // uri that receives GET request
    @GET("arrive/getArrInfoByRoute")

    // category is setting of result format whether many places in rough or one place in detail.
    // options are query values for GET request
    Call<String> DataPos(
            @QueryMap Map<String, String> options
    );


    // base url for request
    public static final Retrofit dataService = new Retrofit.Builder()
            .baseUrl("http://ws.bus.go.kr/api/rest/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build();
}
