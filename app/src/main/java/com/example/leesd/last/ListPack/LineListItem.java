package com.example.leesd.last.ListPack;

/**
 * Created by leesd on 2018-05-05.
 */

public class LineListItem {
    private String lineName; // 노선 이름
    private String next; // 다음 차
    private String andNext; // 다다음 차
    private String neabyStation; // 인근 정류장
    private String firstBus; // 첫차
    private String lastBus; // 막차
    private String interval; // 간격


    public LineListItem(String lineName, String next, String andNext, String neabyStation) { // 간랸 정보
        this.lineName = lineName;
        this.next = next;
        this.andNext = andNext;
        this.neabyStation = neabyStation;
    }

    public LineListItem(String lineName, String next, String andNext, String neabyStation, String firstBus, String lastBus, String interval) { // 상세 정보
        this.lineName = lineName;
        this.next = next;
        this.andNext = andNext;
        this.neabyStation = neabyStation;
        this.firstBus = firstBus;
        this.lastBus = lastBus;
        this.interval = interval;
    }

    public String getFirstBus() {
        return firstBus;
    }

    public void setFirstBus(String firstBus) {
        this.firstBus = firstBus;
    }

    public String getLastBus() {
        return lastBus;
    }

    public void setLastBus(String lastBus) {
        this.lastBus = lastBus;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getLineName(){
        return lineName;
    }

    public void setLineName(String lineName){
        this.lineName = lineName;
    }
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getAndNext() {
        return andNext;
    }

    public void setAndNext(String andNext) {
        this.andNext = andNext;
    }

    public String getNeabyStation(){
        return neabyStation;
    }

    public void setNeabyStation(String neabyStation){
        this.neabyStation = neabyStation;
    }
}
