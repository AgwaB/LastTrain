package com.example.leesd.last;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.leesd.last.GetArrInfoByRouteList.ArrInfoItemList;
import com.example.leesd.last.GetRouteByStationList.RouteItemList;
import com.example.leesd.last.GetStaionByRoute.StationItemList;
import com.example.leesd.last.GetStationByPos.PosItemList;
import com.example.leesd.last.RetrofitCall.AsyncResponseMaps;
import com.example.leesd.last.RetrofitCall.DataServicePos;
import com.example.leesd.last.RetrofitCall.DataServicePosNetworkCall;
import com.example.leesd.last.RetrofitCall.DataServiceStation;
import com.example.leesd.last.RetrofitCall.DataServiceStationNetworkCall;
import com.example.leesd.last.RetrofitCall.GoogleMapsNetworkCall;
import com.example.leesd.last.RetrofitCall.GooglePlaceService;
import com.example.leesd.last.XMLparser.XMLparserPos;
import com.example.leesd.last.XMLparser.XMLparserStation;
import com.example.leesd.last.googlemaps.JsonMaps;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by leesd on 2018-04-01.
 */

public class NearbyActivity extends AppCompatActivity implements AsyncResponseMaps {
    private JsonMaps bus, subway;
    private HashMap<String, String> searchParams;
    private TextView textView, textView2;
    private Button button, button2;
    double longitude = 0;
    double latitude = 0;
    private LocationManager lm;
    private Handler mHandler;
    int check = 0; //check network count

    ArrayList<PosItemList> posItemLists = new ArrayList<PosItemList>();
    ArrayList<RouteItemList> routeItemLists = new ArrayList<RouteItemList>();
    ArrayList<ArrayList<RouteItemList>> routeItemListsPack = new ArrayList<ArrayList<RouteItemList>>();
    ArrayList<StationItemList> stationItemLists = new ArrayList<StationItemList>();
    ArrayList<ArrayList<StationItemList>> stationItemListPack = new ArrayList<ArrayList<StationItemList>>();
    ArrayList<ArrInfoItemList> arrInfoItemLists = new ArrayList<ArrInfoItemList>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        textView = (TextView)findViewById(R.id.text1);
        textView2 = (TextView)findViewById(R.id.text2);
        button = (Button)findViewById(R.id.getData);
        button2 = (Button)findViewById(R.id.getLocation);
        mHandler = new Handler();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("dd", "dd");
                Log.d("longitude", String.valueOf(longitude));
                Log.d("latitude", String.valueOf(latitude));
                if(longitude != 0 && latitude != 0) {
                    check = 0;
                    getBusPosData(126.9488621, 37.5029153);
//                    getData("bus_station", bus);
//                    getData("subway_station", subway);
                    longitude = 0;
                    latitude = 0;
                }
            }
        });

        // LocationManager 객체를 얻어온다
          lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
          findViewById(R.id.getLocation).setOnClickListener(mClickListener);
          button2.performClick();

    } // end of onCreate

    private final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            //여기서 위치값이 갱신되면 이벤트가 발생한다.
            //값은 Location 형태로 리턴되며 좌표 출력 방법은 다음과 같다.

            Log.d("test", "onLocationChanged, location:" + location);
            longitude = location.getLongitude(); //경도
            latitude = location.getLatitude();   //위도
            String provider = location.getProvider();   //위치제공자
            //Gps 위치제공자에 의한 위치변화. 오차범위가 좁다.
            //Network 위치제공자에 의한 위치변화
            //Network 위치는 Gps에 비해 정확도가 많이 떨어진다.
            textView.setText("Longitude : " + longitude + "\n" + "latitude : " + latitude);
        }
        public void onProviderDisabled(String provider) {
            // Disabled시
            Log.d("test", "onProviderDisabled, provider:" + provider);
        }

        public void onProviderEnabled(String provider) {
            // Enabled시
            Log.d("test", "onProviderEnabled, provider:" + provider);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            // 변경시
            Log.d("test", "onStatusChanged, provider:" + provider + ", status:" + status + " ,Bundle:" + extras);
        }
    };

    Button.OnClickListener mClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {

                    try{
                        // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
                        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                                100, // 통지사이의 최소 시간간격 (miliSecond)
                                1, // 통지사이의 최소 변경거리 (m)
                                mLocationListener);
                        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                                100, // 통지사이의 최소 시간간격 (miliSecond)
                                1, // 통지사이의 최소 변경거리 (m)
                                mLocationListener);
                    }catch(SecurityException ex){
                    }

                    //lm.removeUpdates(mLocationListener); // 이거 안하면 비동기적으로 위치값을 계속 받아옴
                }
    };

    public void getData(String type, JsonMaps jsonMaps){
        // add params to HashMap
        searchParams = new HashMap<String, String>();

        searchParams.put("location", Double.toString(latitude) + "," + Double.toString(longitude));
        searchParams.put("radius", "500");
        searchParams.put("type", type);
        searchParams.put("language", "ko");
        searchParams.put("key", getString(R.string.placesKey));

        // build retrofit object
        GooglePlaceService googlePlaceService = GooglePlaceService.retrofit.create(GooglePlaceService.class);

        // call GET request with category and HashMap params
        final Call<JsonMaps> call = googlePlaceService.getPlaces("nearbysearch", searchParams);

        // make a thread for http communication
        GoogleMapsNetworkCall n = new GoogleMapsNetworkCall();

        // set delegate for receiving response object
        n.delegate = NearbyActivity.this;

        // execute background service

        n.execute(call);
//        try {
//            jsonMaps = n.execute(call).get().body();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void processFinish(Response<JsonMaps> response) {
        if(check==0)
            bus = response.body();
        else {
            subway = response.body();
            textView2.setText(bus.getResults().get(0).getName() + "\nsubway : " + subway.getResults().get(0).getName());
        }
        check++;
    }


    public void getBusPosData(double longitude, double latitude){
        searchParams = new HashMap<String, String>();

        searchParams.put("serviceKey", getString(R.string.busDataKey));
        searchParams.put("tmX", Double.toString(longitude));
        searchParams.put("tmY", Double.toString(latitude));
        searchParams.put("radius", "500");

        // build retrofit object
        DataServicePos dataServicePos = DataServicePos.dataService.create(DataServicePos.class);

        // call GET request with category and HashMap params
        final Call<String> call = dataServicePos.DataPos(searchParams);

        // make a thread for http communication
        DataServicePosNetworkCall n = new DataServicePosNetworkCall();

        // set delegate for receiving response object
        n.delegate = NearbyActivity.this;

        // execute background service

        n.execute(call);
    }

    public void getBusRouteData(int arsId){
        searchParams = new HashMap<String, String>();

        searchParams.put("serviceKey", getString(R.string.busDataKey));
        searchParams.put("arsId",Integer.toString(arsId));

        // build retrofit object
        DataServiceStation dataServiceStation = DataServiceStation.dataService.create(DataServiceStation.class);

        // call GET request with category and HashMap params
        final Call<String> call = dataServiceStation.DataPos(searchParams);

        // make a thread for http communication
        DataServiceStationNetworkCall n = new DataServiceStationNetworkCall();

        // set delegate for receiving response object
        n.delegate = NearbyActivity.this;

        // execute background service

        n.execute(call);
    }

    public void getBusStationData(int arsId){
        searchParams = new HashMap<String, String>();

        searchParams.put("serviceKey", getString(R.string.busDataKey));
        searchParams.put("arsId",Integer.toString(arsId));

        // build retrofit object
        DataServiceStation dataServiceStation = DataServiceStation.dataService.create(DataServiceStation.class);

        // call GET request with category and HashMap params
        final Call<String> call = dataServiceStation.DataPos(searchParams);

        // make a thread for http communication
        DataServiceStationNetworkCall n = new DataServiceStationNetworkCall();

        // set delegate for receiving response object
        n.delegate = NearbyActivity.this;

        // execute background service

        n.execute(call);
    }
    @Override
    public void PosProcessFinish(Response<String> response) {
        if(response!=null) {
            Log.d("위치", response.body().toString());
            try {
                XMLparserPos xmLparserPos = new XMLparserPos(response.body().toString());
                posItemLists = xmLparserPos.getPosData();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (PosItemList pos : posItemLists)
                getBusStationData(Integer.parseInt(pos.getArsId()));
        }
    }

    @Override
    public void RProcessFinish(Response<String> response) {

    }

    @Override
    public void RouteProcessFinish(Response<String> response) {

    }

    @Override
    public void StationProcessFinish(Response<String> response) {
        if(response!=null) {
            Log.d("위치2", response.body().toString());
            try {
                XMLparserStation xmLparserStation = new XMLparserStation(response.body().toString());
                stationItemLists = xmLparserStation.getStationData();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            stationItemListPack.add(stationItemLists);
        }

    }

}

