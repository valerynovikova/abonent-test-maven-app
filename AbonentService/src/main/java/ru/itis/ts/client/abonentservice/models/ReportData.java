package ru.itis.ts.client.abonentservice.models;

public class ReportData {
    private String msisdn;
    private int month;
    private int totalTime; // Общее время звонков

    public ReportData(String msisdn, int month, int totalTime) {
        this.msisdn = msisdn;
        this.month = month;
        this.totalTime = totalTime;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public int getMonth() {
        return month;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

}
