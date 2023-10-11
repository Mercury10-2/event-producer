package com.input.eventproducer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonConverter {

    private static final ObjectMapper converter = new ObjectMapper();

    public static String toJson(Object log) throws JsonProcessingException {
        return converter/*.writerWithDefaultPrettyPrinter()*/.writeValueAsString(log);
    }
}
