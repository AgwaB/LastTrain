package com.example.leesd.last.GetRouteByStationList;

/**
 * Created by leesd on 2018-04-08.
 */

public class MsgBody
{
    private RouteItemList[] itemList;

    public RouteItemList[] getItemList ()
    {
        return itemList;
    }

    public void setItemList (RouteItemList[] itemList)
    {
        this.itemList = itemList;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [itemList = "+itemList+"]";
    }
}
