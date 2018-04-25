package com.example.leesd.last.GetRouteByStationList;

/**
 * Created by leesd on 2018-04-08.
 */

public class ServiceResult
{
    private MsgHeader msgHeader;

    private MsgBody msgBody;

    private String comMsgHeader;

    public MsgHeader getMsgHeader ()
    {
        return msgHeader;
    }

    public void setMsgHeader (MsgHeader msgHeader)
    {
        this.msgHeader = msgHeader;
    }

    public MsgBody getMsgBody ()
    {
        return msgBody;
    }

    public void setMsgBody (MsgBody msgBody)
    {
        this.msgBody = msgBody;
    }

    public String getComMsgHeader ()
    {
        return comMsgHeader;
    }

    public void setComMsgHeader (String comMsgHeader)
    {
        this.comMsgHeader = comMsgHeader;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msgHeader = "+msgHeader+", msgBody = "+msgBody+", comMsgHeader = "+comMsgHeader+"]";
    }
}
