package com.input.eventproducer.dto.logs;

import java.util.List;

public class Prototype_Log {
    public String one, two, three;
    public List<String> data;

    public Prototype_Log(String one, String two, String three, List<String> data) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.data = data;
    }
}
