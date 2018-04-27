package com.example.leesd.last;

import android.util.Log;

import com.example.leesd.last.GetStationByPos.PosItemList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by leesd on 2018-04-27.
 */

public class XMLparserPos {
    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    XmlPullParser parser = factory.newPullParser();
    InputStream in;
    String tagName;
    ArrayList<PosItemList> Pos = new ArrayList<PosItemList>();
    PosItemList itemList = new PosItemList();
    public XMLparserPos(String data) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        boolean isItemTag = false;
        in = new ByteArrayInputStream(data.getBytes("UTF-8"));

        parser.setInput(in, "UTF-8");
        while(eventType !=XmlPullParser.END_DOCUMENT){
            if(eventType == XmlPullParser.START_TAG){
                tagName = parser.getName();
                if(tagName.equals("itemList")){ isItemTag = true; itemList = new PosItemList();}

            } else if (eventType == XmlPullParser.TEXT && isItemTag){
                if(tagName.equals("arsId"))
                    itemList.setArsId(parser.getText());

                if(tagName.equals("gpsX"))
                    itemList.setGpsX(parser.getText());

                if(tagName.equals("gpsY"))
                    itemList.setGpsY(parser.getText());

                if(tagName.equals("stationId"))
                    itemList.setStationId(parser.getText());

                if(tagName.equals("stationNm"))
                    itemList.setStationNm(parser.getText());


            } else if(eventType == XmlPullParser.END_TAG){

                tagName = parser.getName();

                if(tagName.equals("itemList")){
                    // 파싱한 데이터 사용 or 저장
                    Pos.add(itemList);

                    isItemTag = false;

                }
            }

            eventType = parser.next();

        }
        for(int i = 0 ; i < Pos.size() ; i++)
        Log.d("ddsfasdfsad", Pos.get(i).getArsId().toString());

    }

    public ArrayList<PosItemList> getPosData(){
        return Pos;
    }

}
