package com.input.eventproducer.utils;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Maths {

    private static Random random = new Random();

    public static int getOrdinal() {
        return random.nextInt(0, 4);
    }
}
