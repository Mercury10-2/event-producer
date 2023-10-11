package com.input.eventproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.input.eventproducer.dto.logs.Prototype_Log;
import com.input.eventproducer.utils.JsonConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class Publisher {

    @Scheduled(fixedRate = 1000)
    private void test() {
        try {
            log.info(JsonConverter.toJson(new Prototype_Log("1", "2", "3", Arrays.asList("1", "2", "3"))));
        } catch (JsonProcessingException e) {
            log.error("Couldn't convert to Json");
            e.printStackTrace();
        }
    }
}
