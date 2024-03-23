package ru.itis.ts.client.abonentservice.repositories;

import ru.itis.ts.client.abonentservice.models.ReportData;

import java.util.List;

public interface ReportRepository {
    List<ReportData> fetchDataFromCDR();
    List<ReportData> filterDataByMsisdn(String msisdn);
    List<ReportData> filterDataByMsisdnAndMonth(String msisdn, int month);
}
