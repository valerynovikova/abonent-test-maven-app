package ru.itis.ts.client.abonentservice.models;

import lombok.Getter;
import lombok.Setter;

public class CDR {

    private String type;

    private String msisdn;

    private long startTime;

    private long endTime;

    public CDR(String type, String msisdn, long startTime, long endTime) {
        this.type = type;
        this.msisdn = msisdn;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
