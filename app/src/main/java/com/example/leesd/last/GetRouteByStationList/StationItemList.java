package com.example.leesd.last.GetRouteByStationList;

/**
 * Created by leesd on 2018-04-08.
 */

public class StationItemList {
    private String busRouteId;

    private String busRouteType;

    private String stBegin;

    private String stEnd;

    private String busRouteNm;

    private String term;

    private String length;

    private String lastBusTmLow;

    private String lastBusTm;

    private String nextBus;

    private String firstBusTmLow;

    private String firstBusTm;

    public String getBusRouteId ()
    {
        return busRouteId;
    }

    public void setBusRouteId (String busRouteId)
    {
        this.busRouteId = busRouteId;
    }

    public String getBusRouteType ()
    {
        return busRouteType;
    }

    public void setBusRouteType (String busRouteType)
    {
        this.busRouteType = busRouteType;
    }

    public String getStBegin ()
    {
        return stBegin;
    }

    public void setStBegin (String stBegin)
    {
        this.stBegin = stBegin;
    }

    public String getStEnd ()
    {
        return stEnd;
    }

    public void setStEnd (String stEnd)
    {
        this.stEnd = stEnd;
    }

    public String getBusRouteNm ()
    {
        return busRouteNm;
    }

    public void setBusRouteNm (String busRouteNm)
    {
        this.busRouteNm = busRouteNm;
    }

    public String getTerm ()
    {
        return term;
    }

    public void setTerm (String term)
    {
        this.term = term;
    }

    public String getLength ()
    {
        return length;
    }

    public void setLength (String length)
    {
        this.length = length;
    }

    public String getLastBusTmLow ()
    {
        return lastBusTmLow;
    }

    public void setLastBusTmLow (String lastBusTmLow)
    {
        this.lastBusTmLow = lastBusTmLow;
    }

    public String getLastBusTm ()
    {
        return lastBusTm;
    }

    public void setLastBusTm (String lastBusTm)
    {
        this.lastBusTm = lastBusTm;
    }

    public String getNextBus ()
    {
        return nextBus;
    }

    public void setNextBus (String nextBus)
    {
        this.nextBus = nextBus;
    }

    public String getFirstBusTmLow ()
    {
        return firstBusTmLow;
    }

    public void setFirstBusTmLow (String firstBusTmLow)
    {
        this.firstBusTmLow = firstBusTmLow;
    }

    public String getFirstBusTm ()
    {
        return firstBusTm;
    }

    public void setFirstBusTm (String firstBusTm)
    {
        this.firstBusTm = firstBusTm;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [busRouteId = "+busRouteId+", busRouteType = "+busRouteType+", stBegin = "+stBegin+", stEnd = "+stEnd+", busRouteNm = "+busRouteNm+", term = "+term+", length = "+length+", lastBusTmLow = "+lastBusTmLow+", lastBusTm = "+lastBusTm+", nextBus = "+nextBus+", firstBusTmLow = "+firstBusTmLow+", firstBusTm = "+firstBusTm+"]";
    }
}
