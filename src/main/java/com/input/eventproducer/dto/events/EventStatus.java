package com.input.eventproducer.dto.events;

public enum EventStatus {
    CREATED("created"),
    SENT_TO_BUS("sent_to_bus"),
    RECEIVED_BY_BUS("received_by_bus");
    EventStatus(String step) {}
}
