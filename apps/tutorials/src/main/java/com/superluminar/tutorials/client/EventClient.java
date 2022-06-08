package com.superluminar.tutorials.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(value = "events", path = "/api")
public interface EventClient {

    @PostMapping("/events")
    Map<String, Object> createEvent(@RequestBody Map<String, Object> event);
}
