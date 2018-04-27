package com.example.leesd.last.GetStationByPos;

/**
 * Created by leesd on 2018-04-08.
 */

public class MsgBody
{
    private PosItemList[] itemList;

    public PosItemList[] getItemList ()
    {
        return itemList;
    }

    public void setItemList (PosItemList[] itemList)
    {
        this.itemList = itemList;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [itemList = "+itemList+"]";
    }
}
