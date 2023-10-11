package com.input.eventproducer.utils;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class Time {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void waitMillis(int millis) {
        try { Thread.sleep(millis); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    public static String getNowUTC() {
        return ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC"))
                .toLocalDateTime()
                .format(dateTimeFormatter);
    }
}
