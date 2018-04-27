package com.example.leesd.last;

import android.util.Log;

import com.example.leesd.last.GetRouteByStationList.StationItemList;
import com.example.leesd.last.GetStationByPos.PosItemList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by leesd on 2018-04-28.
 */

public class XMLparserStationList {

    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    XmlPullParser parser = factory.newPullParser();
    InputStream in;
    String tagName;
    ArrayList<StationItemList> station = new ArrayList<StationItemList>();
    StationItemList itemList = new StationItemList();
    public XMLparserStationList(String data) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        boolean isItemTag = false;
        in = new ByteArrayInputStream(data.getBytes("UTF-8"));

        parser.setInput(in, "UTF-8");
        while(eventType !=XmlPullParser.END_DOCUMENT){
            if(eventType == XmlPullParser.START_TAG){
                tagName = parser.getName();
                if(tagName.equals("itemList")){ isItemTag = true; itemList = new StationItemList();}

            } else if (eventType == XmlPullParser.TEXT && isItemTag){
                if(tagName.equals("busRouteId"))
                    itemList.setBusRouteId(parser.getText());

                if(tagName.equals("busRouteNm"))
                    itemList.setBusRouteNm(parser.getText());

            } else if(eventType == XmlPullParser.END_TAG){

                tagName = parser.getName();

                if(tagName.equals("itemList")){
                    // 파싱한 데이터 사용 or 저장
                    station.add(itemList);

                    isItemTag = false;

                }
            }

            eventType = parser.next();

        }
        for(int i = 0 ; i < station.size() ; i++)
            Log.d("ddsfasdfsad", station.get(i).getBusRouteId().toString());

    }

    public ArrayList<StationItemList> getPosData(){
        return station;
    }
}
