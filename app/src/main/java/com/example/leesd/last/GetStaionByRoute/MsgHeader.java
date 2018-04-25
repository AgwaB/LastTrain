package com.example.leesd.last.GetStaionByRoute;

/**
 * Created by leesd on 2018-04-08.
 */

public class MsgHeader {
    private String headerCd;

    private String itemCount;

    private String headerMsg;

    public String getHeaderCd ()
    {
        return headerCd;
    }

    public void setHeaderCd (String headerCd)
    {
        this.headerCd = headerCd;
    }

    public String getItemCount ()
    {
        return itemCount;
    }

    public void setItemCount (String itemCount)
    {
        this.itemCount = itemCount;
    }

    public String getHeaderMsg ()
    {
        return headerMsg;
    }

    public void setHeaderMsg (String headerMsg)
    {
        this.headerMsg = headerMsg;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [headerCd = "+headerCd+", itemCount = "+itemCount+", headerMsg = "+headerMsg+"]";
    }
}
