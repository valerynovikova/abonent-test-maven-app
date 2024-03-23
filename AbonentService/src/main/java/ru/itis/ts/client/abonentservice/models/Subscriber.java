package ru.itis.ts.client.abonentservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String msisdn;
    private String name;


    public Subscriber(String msisdn, String name) {
        this.msisdn = msisdn;
        this.name = name;
    }
}
