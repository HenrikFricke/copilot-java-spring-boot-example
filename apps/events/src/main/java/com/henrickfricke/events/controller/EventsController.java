package com.henrickfricke.events.controller;

import com.henrickfricke.events.model.Event;
import com.henrickfricke.events.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventsController {
    final EventsRepository eventsRepository;

    @Autowired
    public EventsController(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> list() {
        var events = eventsRepository.findAll();

        return ResponseEntity.ok(events);
    }

    @PostMapping("/events")
    public ResponseEntity<Event> create(@RequestParam String identifier) {
        var e = new Event(identifier);
        return new ResponseEntity<>(eventsRepository.save(e), HttpStatus.CREATED);
    }
}
