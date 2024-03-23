package ru.itis.ts.client.abonentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.ts.client.abonentservice.models.Subscriber;
@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

}