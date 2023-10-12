package com.input.eventproducer.service;

import com.input.eventproducer.dto.events.Event;
import com.input.eventproducer.dto.events.EventStatus;
import com.input.eventproducer.dto.events.EventType;
import com.input.eventproducer.utils.Maths;
import com.input.eventproducer.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class Publishing {

    private final int maxNumberOfInserts = 100;
    private final long persistenceRateMillis = 500;

    private final Logging logger = new Logging();
    private final Persistence persistence = new Persistence();
    private final Queue<Event> newlyCreatedEvents = new ArrayDeque<>(10000);
    private final List<Integer> batchSizes = new ArrayList<>(maxNumberOfInserts);

    private boolean timeToPersist = false;

    /**
     * Запускает процесса генерации событий
     */
    public void eventStreamingStarter() {
        while (true) {
            Event event = createEvent();
            newlyCreatedEvents.add(event);
            if (timeToPersist)
                persistNewlyCreatedEvents();
            logger.asyncLog(event);
            Time.waitMillis(100);
        }
    }

    /**
     * Зажигает флаг необходимости сохранения данных в базу
     */
    @Scheduled(initialDelay = persistenceRateMillis, fixedRate = persistenceRateMillis)
    private void allowPersistence() {
        timeToPersist = true;
    }

    /**
     * Сохраняет данные, обнуляет очередь и гасит флаг
     */
    private void persistNewlyCreatedEvents() {
        persistence.insertEvents(new ArrayList<>(newlyCreatedEvents));
        batchSizes.add(newlyCreatedEvents.size());
        if (batchSizes.size() == maxNumberOfInserts)
            computeBatchStats();
        newlyCreatedEvents.clear();
        timeToPersist = false;
    }

    /**
     * Считает статистику по размерам массивов данных за период
     */
    private void computeBatchStats() {

        batchSizes.clear();
    }

    /**
     * Создание события
     */
    private Event createEvent() {
        return new Event(
                Time.getNowUTC() + UUID.randomUUID(),
                EventType.values()[Maths.getOrdinal()],
                EventStatus.CREATED);
    }
}
