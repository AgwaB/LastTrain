package com.example.leesd.last.GetStaionByRoute;

/**
 * Created by leesd on 2018-04-08.
 */

public class MsgBody
{
    private ItemList[] itemList;

    public ItemList[] getItemList ()
    {
        return itemList;
    }

    public void setItemList (ItemList[] itemList)
    {
        this.itemList = itemList;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [itemList = "+itemList+"]";
    }
}
