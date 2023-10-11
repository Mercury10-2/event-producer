package com.input.eventproducer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonConverter {

    private static final ObjectMapper converter = new ObjectMapper();
    private static final String exception = "Couldn't convert to Json";

    public static String toJson(Object log) {
        try {
            return converter/*.writerWithDefaultPrettyPrinter()*/.writeValueAsString(log);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return exception;
        }
    }
}
