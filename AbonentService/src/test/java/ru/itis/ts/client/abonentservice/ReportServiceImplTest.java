package ru.itis.ts.client.abonentservice;
import org.junit.jupiter.api.Test;
import ru.itis.ts.client.abonentservice.models.ReportData;
import ru.itis.ts.client.abonentservice.repositories.ReportRepository;
import ru.itis.ts.client.abonentservice.services.ReportServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ReportServiceImplTest {

    @Test
    public void testGenerateReport() {
        // мокированный объект ReportRepository
        ReportRepository reportRepositoryMock = mock(ReportRepository.class);

        // экземпляр класса ReportServiceImpl с мокированным объектом ReportRepository
        ReportServiceImpl reportService = new ReportServiceImpl(reportRepositoryMock);

        // тестовые данные для отчета
        List<ReportData> testReportData = new ArrayList<>();
        testReportData.add(new ReportData("Subscriber1", 1,12));
        testReportData.add(new ReportData("Subscriber2", 2,20));

        //  поведение мокированного объекта ReportRepository
        when(reportRepositoryMock.fetchDataFromCDR()).thenReturn(testReportData);

        // метод, который тестируем
        reportService.generateReport();

        // проверяем, что метод displayReportInConsole() вызывается один раз с тестовыми данными
        verify(reportRepositoryMock, times(1)).fetchDataFromCDR();
    }
}
