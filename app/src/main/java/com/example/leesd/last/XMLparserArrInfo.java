package com.example.leesd.last;

import android.util.Log;

import com.example.leesd.last.GetArrInfoByRouteList.ArrInfoItemList;
import com.example.leesd.last.GetRouteByStationList.RouteItemList;

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

public class XMLparserArrInfo {
    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    XmlPullParser parser = factory.newPullParser();
    InputStream in;
    String tagName;
    ArrayList<ArrInfoItemList> arrInfo = new ArrayList<ArrInfoItemList>();
    ArrInfoItemList itemList = new ArrInfoItemList();
    public XMLparserArrInfo(String data) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        boolean isItemTag = false;
        in = new ByteArrayInputStream(data.getBytes("UTF-8"));

        parser.setInput(in, "UTF-8");
        while(eventType !=XmlPullParser.END_DOCUMENT){
            if(eventType == XmlPullParser.START_TAG){
                tagName = parser.getName();
                if(tagName.equals("itemList")){ isItemTag = true; itemList = new ArrInfoItemList();}

            } else if (eventType == XmlPullParser.TEXT && isItemTag){
                if(tagName.equals("arrmsg1"))
                    itemList.setArrmsg1(parser.getText());

                if(tagName.equals("plainNo1"))
                    itemList.setPlainNo1(parser.getText());

                if(tagName.equals("arrmsg2"))
                    itemList.setArrmsg2(parser.getText());

                if(tagName.equals("plainNo2"))
                    itemList.setPlainNo2(parser.getText());

            } else if(eventType == XmlPullParser.END_TAG){

                tagName = parser.getName();

                if(tagName.equals("itemList")){
                    // 파싱한 데이터 사용 or 저장
                    arrInfo.add(itemList);

                    isItemTag = false;

                }
            }

            eventType = parser.next();

        }
        for(int i = 0 ; i < arrInfo.size() ; i++)
            Log.d("ddsfasdfsad", arrInfo.get(i).getBusRouteId().toString());

    }

    public ArrayList<ArrInfoItemList> getPosData(){
        return arrInfo;
    }
}
