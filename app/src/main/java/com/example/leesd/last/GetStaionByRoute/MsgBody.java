package com.example.leesd.last.GetStaionByRoute;

/**
 * Created by leesd on 2018-04-08.
 */

public class MsgBody
{
    private StationItemList[] stationItemList;

    public StationItemList[] getStationItemList()
    {
        return stationItemList;
    }

    public void setStationItemList(StationItemList[] stationItemList)
    {
        this.stationItemList = stationItemList;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [stationItemList = "+ stationItemList +"]";
    }
}
