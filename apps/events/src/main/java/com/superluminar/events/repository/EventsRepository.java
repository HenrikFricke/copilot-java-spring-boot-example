package com.superluminar.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.superluminar.events.model.Event;

import java.util.Date;
import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Long> {
    List<Event> findByPublishedAtAfter(Date publishedAt);

    List<Event> findByIdentifier(String identifier);
}