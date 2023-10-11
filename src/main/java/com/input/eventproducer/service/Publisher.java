package com.input.eventproducer.service;

import com.input.eventproducer.dto.events.Event;
import com.input.eventproducer.dto.events.EventStatus;
import com.input.eventproducer.dto.events.EventType;
import com.input.eventproducer.utils.JsonConverter;
import com.input.eventproducer.utils.Maths;
import com.input.eventproducer.utils.Time;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class Publisher {

    @Scheduled(fixedRate = 1000)
    private void eventStreamingStarter() {
        while (true) {
            Event event = createEvent();
            log.info(JsonConverter.toJson(event));
//            Time.waitMillis(1000);
        }
    }

    private Event createEvent() {
        return new Event(
                Time.getNowUTC() + UUID.randomUUID(),
                EventType.values()[Maths.getOrdinal()],
                EventStatus.CREATED);
    }
}
