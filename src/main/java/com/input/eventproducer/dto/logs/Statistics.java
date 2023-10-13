package com.input.eventproducer.dto.logs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.input.eventproducer.dto.events.EventType;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Собирает статистику по создаваемым событиям:
 *      - минимальный, максимальный и средний размеры сохраняемых массивов
 *      -
 */
public class Statistics {

    @JsonIgnore
    public List<Integer> batchSizes;
    @JsonIgnore
    public Map<String, List<Long>> methodPerformance;
    @JsonIgnore
    public LocalDateTime startingPoint;

    public Map<String, String> batches;
    public Map<String, Integer> eventTypes;
    public Map<String, Double> averagePerformanceAndRunsByMethods; // поменять структуру
    public Map<String, Integer> methodRuns;

    public Statistics(LocalDateTime startingPoint, int maxNumberOfInserts) {
        this.startingPoint = startingPoint;
        this.batchSizes = new ArrayList<>(maxNumberOfInserts);
        this.batches = Map.of(
                "minBatchSize", "0",
                "maxBatchSize", "0",
                "averageBatchSize", "0");
        this.eventTypes = new HashMap<>();
        Arrays.stream(EventType.values()).forEach(eventType -> eventTypes.put(eventType.toString(), 0));
        this.averagePerformanceAndRunsByMethods = new LinkedHashMap<>();
        methodRuns = new HashMap<>();
    }
}
