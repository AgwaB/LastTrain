package com.example.leesd.last.ListPack;

import java.util.ArrayList;

/**
 * Created by leesd on 2018-05-05.
 */

public class StationListItem {
    private String stationName; // 정류장 이름
    private String distance; // 현재 위치와의 거리
    private String stopLine; // listview에 표시 할 때 stops를 가져와서 표시
    private ArrayList<String> stops; // 정차노선들

    public StationListItem(String stationName, String distance, ArrayList<String> stops) {
        this.stationName = stationName;
        this.distance = distance;
        this.stops = stops;
    }

    public StationListItem(String stationName, String distance, String stopLine) {
        this.stationName = stationName;
        this.distance = distance;
        this.stopLine = stopLine;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public ArrayList<String> getStops() {
        return stops;
    }

    public void setStops(ArrayList<String> stops) {
        this.stops = stops;
    }

    public String getStopLine(){
        String lines = null;
        for(String line : getStops()){
            lines += line;
        }
        return lines;
    }
}
