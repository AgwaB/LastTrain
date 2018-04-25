package com.example.leesd.last.GetStationByPos;

/**
 * Created by leesd on 2018-04-08.
 */

public class ItemList {
    private String gpsX;

    private String posY;

    private String stationNm;

    private String gpsY;

    private String posX;

    private String stationId;

    private String stationTp;

    private String arsId;

    private String dist;

    public String getGpsX ()
    {
        return gpsX;
    }

    public void setGpsX (String gpsX)
    {
        this.gpsX = gpsX;
    }

    public String getPosY ()
    {
        return posY;
    }

    public void setPosY (String posY)
    {
        this.posY = posY;
    }

    public String getStationNm ()
    {
        return stationNm;
    }

    public void setStationNm (String stationNm)
    {
        this.stationNm = stationNm;
    }

    public String getGpsY ()
    {
        return gpsY;
    }

    public void setGpsY (String gpsY)
    {
        this.gpsY = gpsY;
    }

    public String getPosX ()
    {
        return posX;
    }

    public void setPosX (String posX)
    {
        this.posX = posX;
    }

    public String getStationId ()
    {
        return stationId;
    }

    public void setStationId (String stationId)
    {
        this.stationId = stationId;
    }

    public String getStationTp ()
    {
        return stationTp;
    }

    public void setStationTp (String stationTp)
    {
        this.stationTp = stationTp;
    }

    public String getArsId ()
    {
        return arsId;
    }

    public void setArsId (String arsId)
    {
        this.arsId = arsId;
    }

    public String getDist ()
    {
        return dist;
    }

    public void setDist (String dist)
    {
        this.dist = dist;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [gpsX = "+gpsX+", posY = "+posY+", stationNm = "+stationNm+", gpsY = "+gpsY+", posX = "+posX+", stationId = "+stationId+", stationTp = "+stationTp+", arsId = "+arsId+", dist = "+dist+"]";
    }
}
