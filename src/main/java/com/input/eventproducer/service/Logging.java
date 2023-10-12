package com.input.eventproducer.service;

import com.input.eventproducer.utils.JsonConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Logging {

    @Async(value = "asyncPoolExecutor")
    public void asyncLog(Object object) {
        log.info(JsonConverter.toJson(object));
    }

    @Async(value = "asyncPoolExecutor")
    public void logEventBatchesStats(String average, String min, String max) {

    }
}
