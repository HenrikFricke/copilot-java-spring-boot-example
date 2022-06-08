package com.superluminar.events.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class EventDTO {
    @NotEmpty

    public final String identifier;

    EventDTO(@JsonProperty("identifier") String identifier) {
        super();
        this.identifier = identifier;
    }
}
