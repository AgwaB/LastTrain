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

public class StationListNetworkCall extends AsyncTask<Call, Void, Response<StationListMainInfo>> {
    public AsyncResponseMaps delegate = null;
    @Override
    protected Response<StationListMainInfo> doInBackground(Call... params){
        // execute thread for background http call
        try {

            Call<StationListMainInfo> call = params[0]; // get call params
            Response<StationListMainInfo> response = call.execute(); // execute call

            return response;

        } catch (Exception e){

            Log.e("AsyncTask", e.getMessage());
        }

        return null;
    }


    @Override
    protected void onPostExecute(Response<StationListMainInfo> response){
        // call if doInBackground returns response or null

        // send a response object to activity
        delegate.StationListProcessFinish(response);
    }
}
