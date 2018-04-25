package com.example.leesd.last.GetStaionByRoute;

/**
 * Created by leesd on 2018-04-08.
 */

public class RouteMainInfo {
    private com.example.leesd.last.GetStaionByRoute.ServiceResult ServiceResult;

    public com.example.leesd.last.GetStaionByRoute.ServiceResult getServiceResult ()
    {
        return ServiceResult;
    }

    public void setServiceResult (com.example.leesd.last.GetStaionByRoute.ServiceResult ServiceResult)
    {
        this.ServiceResult = ServiceResult;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ServiceResult = "+ServiceResult+"]";
    }
}
