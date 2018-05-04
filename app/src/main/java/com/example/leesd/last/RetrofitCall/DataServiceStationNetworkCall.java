package com.example.leesd.last.RetrofitCall;

import android.os.AsyncTask;
import android.util.Log;

import com.example.leesd.last.GetArrInfoByRouteList.RouteListMainInfo;
import com.example.leesd.last.GetRouteByStationList.StationListMainInfo;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by leesd on 2018-04-08.
 */

public class DataServiceStationNetworkCall extends AsyncTask<Call, Void, Response<String>> {
    public AsyncResponseMaps delegate = null;
    @Override
    protected Response<String> doInBackground(Call... params){
        // execute thread for background http call
        try {

            Call<String> call = params[0]; // get call params
            Response<String> response = call.execute(); // execute call

            return response;

        } catch (Exception e){

            Log.e("AsyncTask", e.getMessage());
        }

        return null;
    }


    @Override
    protected void onPostExecute(Response<String> response){
        // call if doInBackground returns response or null

        // send a response object to activity
        delegate.StationProcessFinish(response);
    }
}
