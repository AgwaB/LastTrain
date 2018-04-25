package com.example.leesd.last.GetRouteByStationList;

/**
 * Created by leesd on 2018-04-08.
 */

public class StationListMainInfo {
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
