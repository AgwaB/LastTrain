package com.example.leesd.last.GetStationByPos;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by leesd on 2018-04-08.
 */

public class PosMainInfo {
    @Root(name="comMsgHeader")
    private ServiceResult ServiceResult;

    public ServiceResult getServiceResult ()
    {
        return ServiceResult;
    }

    public void setServiceResult (ServiceResult ServiceResult)
    {
        this.ServiceResult = ServiceResult;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ServiceResult = "+ServiceResult+"]";
    }
}
