package ru.itis.ts.client.abonentservice;


import org.junit.jupiter.api.Test;
import ru.itis.ts.client.abonentservice.services.CDRGeneratorService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class CDRGeneratorServiceTest {

    @Test
    void testGenerateRandomTime() {
        CDRGeneratorService cdrGeneratorService = new CDRGeneratorService();

        long minTime = 1609459200; // Допустимый минимальный Unix timestamp
        long maxTime = 1640995200; // Допустимый максимальный Unix timestamp

        long randomTime = cdrGeneratorService.generateRandomTime(minTime, maxTime);

        assertTrue(randomTime >= minTime && randomTime <= maxTime, "Random time is within the specified range");
    }
    @Test
    public void testGenerateCDRFile() {
        CDRGeneratorService cdrGeneratorService = new CDRGeneratorService();

        assertDoesNotThrow(cdrGeneratorService::generateCDRFile);

    }


}


