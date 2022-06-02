package com.henrickfricke.events.repository;

import com.henrickfricke.events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Long> {
    List<Event> findByPublishedAtAfter(Date publishedAt);

    List<Event> findByIdentifier(String identifier);
}