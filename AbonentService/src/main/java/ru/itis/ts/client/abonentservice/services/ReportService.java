package ru.itis.ts.client.abonentservice.services;

import ru.itis.ts.client.abonentservice.models.ReportData;

import java.util.List;

public interface ReportService {
    void generateReport();
    void generateReport(String msisdn);
    void generateReport(String msisdn, int month);


}
