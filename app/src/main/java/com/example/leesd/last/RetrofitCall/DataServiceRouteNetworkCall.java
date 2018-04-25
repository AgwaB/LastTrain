package com.example.leesd.last.RetrofitCall;

import android.os.AsyncTask;
import android.util.Log;

import com.example.leesd.last.GetStaionByRoute.RouteMainInfo;
import com.example.leesd.last.GetStationByPos.PosMainInfo;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by leesd on 2018-04-08.
 */

public class DataServiceRouteNetworkCall extends AsyncTask<Call, Void, Response<RouteMainInfo>> {
    public AsyncResponseMaps delegate = null;
    @Override
    protected Response<RouteMainInfo> doInBackground(Call... params){
        // execute thread for background http call
        try {

            Call<RouteMainInfo> call = params[0]; // get call params
            Response<RouteMainInfo> response = call.execute(); // execute call

            return response;

        } catch (Exception e){

            Log.e("AsyncTask", e.getMessage());
        }

        return null;
    }


    @Override
    protected void onPostExecute(Response<RouteMainInfo> response){
        // call if doInBackground returns response or null

        // send a response object to activity
        delegate.RouteProcessFinish(response);
    }
}
