package com.input.eventproducer.dto.events;

public enum EventType {
    MESSAGE("message"),
    CALL("call"),
    LETTER("letter"),
    MEETING("meeting");
    EventType(String type) {}
}
