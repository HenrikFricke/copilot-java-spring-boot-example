package com.henrikfricke.tutorials.client;

import com.henrickfricke.events.model.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "EVENTS", path = "/api")
public interface EventClient {

    @PostMapping("/events")
    Event createEvent(@RequestBody Event event);
}
