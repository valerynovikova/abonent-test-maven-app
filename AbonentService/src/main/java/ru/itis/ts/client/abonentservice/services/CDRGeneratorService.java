package ru.itis.ts.client.abonentservice.services;

import ru.itis.ts.client.abonentservice.models.CDR;

import java.util.Random;

// Сервис для генерации CDR файлов
public class CDRGeneratorService {
    private static final String[] CALL_TYPES = {"01", "02"};
    private static final int NUMBER_OF_SUBSCRIBERS = 10;

    private Random random = new Random();

    // Генерация случайного времени в определенном диапазоне
    public long generateRandomTime(long minTime, long maxTime) {
        return minTime + random.nextInt((int) (maxTime - minTime));
    }

    // Генерация CDR файла
    public void generateCDRFile() {
        for (int i = 0; i < 12; i++) { // Генерируем данные за 12 месяцев
            for (int j = 0; j < NUMBER_OF_SUBSCRIBERS; j++) {
                String msisdn = "Subscriber" + j;
                String type = CALL_TYPES[random.nextInt(CALL_TYPES.length)];
                long startTime = generateRandomTime(1609459200, 1640995200); // Unix timestamp за 2023 год
                long endTime = generateRandomTime(startTime, startTime + 3600); // Длительность звонка до 1 часа

                CDR cdr = new CDR(type, msisdn, startTime, endTime);
                saveCDRtoDB(cdr); // Сохраняем данные о транзакциях в базу данных
            }
        }
    }

    // Метод для сохранения данных о транзакциях в базу данных
    private void saveCDRtoDB(CDR cdr) {
        // Реализация сохранения данных о транзакциях в базу данных
        System.out.println("Saved CDR: " + cdr.getMsisdn() + ", Type: " + cdr.getType() + ", Start Time: " + cdr.getStartTime() + ", End Time: " + cdr.getEndTime());
    }

    public static void main(String[] args) {
        CDRGeneratorService cdrGeneratorService = new CDRGeneratorService();
        cdrGeneratorService.generateCDRFile();
    }
}
