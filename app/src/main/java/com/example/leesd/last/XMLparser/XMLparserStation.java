package com.example.leesd.last.XMLparser;

import android.util.Log;

import com.example.leesd.last.GetRouteByStationList.RouteItemList;
import com.example.leesd.last.GetStaionByRoute.StationItemList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by leesd on 2018-05-04.
 */

public class XMLparserStation {
    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    XmlPullParser parser = factory.newPullParser();
    InputStream in;
    String tagName;
    ArrayList<StationItemList> station = new ArrayList<StationItemList>();
    StationItemList itemList = new StationItemList();
    public XMLparserStation(String data) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        boolean isItemTag = false;
        in = new ByteArrayInputStream(data.getBytes("UTF-8"));

        parser.setInput(in, "UTF-8");
        while(eventType !=XmlPullParser.END_DOCUMENT){
            if(eventType == XmlPullParser.START_TAG){
                tagName = parser.getName();
                if(tagName.equals("itemList")){ isItemTag = true; itemList = new StationItemList();}

            } else if (eventType == XmlPullParser.TEXT && isItemTag){
                if(tagName.equals("arrmsg1"))
                    itemList.setArrmsg1(parser.getText());

                if(tagName.equals("arrmsg2"))
                    itemList.setArrmsg2(parser.getText());

                if(tagName.equals("firstTm"))
                    itemList.setFirstTm(parser.getText());

                if(tagName.equals("isFullFlag1"))
                    itemList.setIsFullFlag1(parser.getText());

                if(tagName.equals("isFullFlag2"))
                    itemList.setIsFullFlag2(parser.getText());

                if(tagName.equals("isLast1"))
                    itemList.setIsLast1(parser.getText());

                if(tagName.equals("isLast2"))
                    itemList.setIsLast2(parser.getText());

                if(tagName.equals("lastTm"))
                    itemList.setLastTm(parser.getText());

                if(tagName.equals("nextBus"))
                    itemList.setIsFullFlag1(parser.getText());

                if(tagName.equals("nxtStn"))
                    itemList.setNxtStn(parser.getText());

                if(tagName.equals("rtNm"))
                    itemList.setRtNm(parser.getText());

                if(tagName.equals("stNm"))
                    itemList.setStNm(parser.getText());


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
            Log.d("StationData", station.get(i).getRtNm());

    }

    public ArrayList<StationItemList> getStationData(){
        return station;
    }
}

