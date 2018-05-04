package com.example.leesd.last.GetArrInfoByRouteList;

/**
 * Created by leesd on 2018-04-08.
 */

public class MsgBody
{
    private ArrInfoItemList[] arrInfoItemList;

    public ArrInfoItemList[] getArrInfoItemList()
    {
        return arrInfoItemList;
    }

    public void setArrInfoItemList(ArrInfoItemList[] arrInfoItemList)
    {
        this.arrInfoItemList = arrInfoItemList;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [arrInfoItemList = "+ arrInfoItemList +"]";
    }
}
