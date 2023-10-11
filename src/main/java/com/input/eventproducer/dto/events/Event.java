package com.input.eventproducer.dto.events;

public class Event {
    public String traceId;
    public EventType type;
    public EventStatus status;

    public Event(String traceId, EventType type, EventStatus status) {
        this.traceId = traceId;
        this.type = type;
        this.status = status;
    }
}
