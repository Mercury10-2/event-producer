package com.input.eventproducer;

import com.input.eventproducer.service.Publisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventProducerApplication.class, args);
        new Publisher().eventStreamingStarter();
    }

}
