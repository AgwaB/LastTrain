package com.example.leesd.last.RetrofitCall;

import com.example.leesd.last.GetRouteByStationList.StationListMainInfo;
import com.example.leesd.last.GetStationByPos.PosMainInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by leesd on 2018-04-08.
 */

public interface DataServiceStation { // 노선별 경유 정류소 조회 서비스

    // uri that receives GET request
    @GET("stationinfo/getStationByUid")

    // category is setting of result format whether many places in rough or one place in detail.
    // options are query values for GET request
    Call<String> DataPos(
            @QueryMap Map<String, String> options
    );


    // base url for request
    public static final Retrofit dataService = new Retrofit.Builder()
            .baseUrl("http://ws.bus.go.kr/api/rest/")
            //.addConverterFactory(SimpleXmlConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();
}
