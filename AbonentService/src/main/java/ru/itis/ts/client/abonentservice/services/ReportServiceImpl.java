package ru.itis.ts.client.abonentservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.ts.client.abonentservice.models.ReportData;
import ru.itis.ts.client.abonentservice.repositories.ReportRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public void generateReport() {
        List<ReportData> allReportData = reportRepository.fetchDataFromCDR();
        displayReportInConsole(allReportData);
    }

    @Override
    public void generateReport(String msisdn) {
        List<ReportData> filteredData = reportRepository.filterDataByMsisdn(msisdn);
        displayReportInConsole(filteredData);
    }

    @Override
    public void generateReport(String msisdn, int month) {
        List<ReportData> filteredData = reportRepository.filterDataByMsisdnAndMonth(msisdn, month);
        displayReportInConsole(filteredData);
    }

    private void displayReportInConsole(List<ReportData> reportData) {
        System.out.println("Отчет:");

        for (ReportData data : reportData) {
            System.out.println("Абонент: " + data.getMsisdn());
            System.out.println("Месяц: " + data.getMonth());
            System.out.println("-----------------------------------------");
        }
    }
    private void saveReportToFile(String msisdn, int month, List<ReportData> reportData) {
        ObjectMapper objectMapper = new ObjectMapper();
        String filename = "reports/" + msisdn + "_" + month + ".json";

        try {
            File file = new File(filename);
            file.getParentFile().mkdirs(); // Создание директории, если не существует
            objectMapper.writeValue(file, reportData);
            System.out.println("Отчет успешно сохранен в файл: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении отчета в файл: " + e.getMessage());
        }
    }
}
