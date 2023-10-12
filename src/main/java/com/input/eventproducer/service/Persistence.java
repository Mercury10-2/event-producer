package com.input.eventproducer.service;

import com.input.eventproducer.dto.events.Event;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Persistence {

    @Async(value = "asyncPoolExecutor")
    public void insertEvents(List<Event> newlyCreatedEvents) {

    }
}
