package com.henrickfricke.events.controller;

import com.henrickfricke.events.dto.EventDTO;
import com.henrickfricke.events.model.Event;
import com.henrickfricke.events.repository.EventsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EventsController {

    final EventsRepository eventsRepository;

    @Autowired
    public EventsController(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> list() {
        var events = eventsRepository.findAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(events);
    }

    @PostMapping("/events")
    public ResponseEntity<Event> create(@Valid @RequestBody EventDTO e) {
        log.info(e.identifier);
        return new ResponseEntity<>(eventsRepository.save(new Event(e.identifier)), HttpStatus.CREATED);
    }
}
