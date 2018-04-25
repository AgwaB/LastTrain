package com.example.leesd.last.GetArrInfoByRouteList;

/**
 * Created by leesd on 2018-04-08.
 */

public class RouteListMainInfo {
    private com.example.leesd.last.GetArrInfoByRouteList.ServiceResult ServiceResult;

    public com.example.leesd.last.GetArrInfoByRouteList.ServiceResult getServiceResult ()
    {
        return ServiceResult;
    }

    public void setServiceResult (com.example.leesd.last.GetArrInfoByRouteList.ServiceResult ServiceResult)
    {
        this.ServiceResult = ServiceResult;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ServiceResult = "+ServiceResult+"]";
    }
}
