package ru.itis.ts.client.abonentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.ts.client.abonentservice.models.Subscriber;
import ru.itis.ts.client.abonentservice.repositories.SubscriberRepository;

@Service
public class SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    public void saveSubscriber(String msisdn, String name) {
        Subscriber subscriber = new Subscriber(msisdn, name);
        subscriberRepository.save(subscriber);
    }
}