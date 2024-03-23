package ru.itis.ts.client.abonentservice.repositories;

import ru.itis.ts.client.abonentservice.models.ReportData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {

    @Override
    public List<ReportData> fetchDataFromCDR() {
        List<ReportData> reportDataList = new ArrayList<>();
        String filename = "cdr_data.csv"; // Путь к файлу CDR

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    ReportData reportData = new ReportData(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                    reportDataList.add(reportData);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении данных из файла CDR: " + e.getMessage());
        }

        return reportDataList;
    }

    @Override
    public List<ReportData> filterDataByMsisdn(String msisdn) {
        List<ReportData> filteredList = new ArrayList<>();
        List<ReportData> allReportData = fetchDataFromCDR();

        for (ReportData data : allReportData) {
            if (data.getMsisdn().equals(msisdn)) {
                filteredList.add(data);
            }
        }

        return filteredList;
    }

    @Override
    public List<ReportData> filterDataByMsisdnAndMonth(String msisdn, int month) {
        List<ReportData> filteredList = new ArrayList<>();
        List<ReportData> allReportData = fetchDataFromCDR();

        for (ReportData data : allReportData) {
            if (data.getMsisdn().equals(msisdn) && data.getMonth() == month) {
                filteredList.add(data);
            }
        }

        return filteredList;
    }
}
