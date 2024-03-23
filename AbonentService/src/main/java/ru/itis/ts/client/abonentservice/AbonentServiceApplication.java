package ru.itis.ts.client.abonentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AbonentServiceApplication {

    public static void main(String[] args) {

        generateReport();

        SpringApplication.run(AbonentServiceApplication.class, args);
    }

    public static void generateReport() {

        System.out.println("Метод генерации отчета");
    }
}
