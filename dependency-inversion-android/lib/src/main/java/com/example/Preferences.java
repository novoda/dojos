package com.example;

import java.util.HashMap;
import java.util.Map;

public class Preferences {

    public static final Preferences instance = new Preferences();
    private final Map<String, String> cache = new HashMap<>();

    String valueForKey(String key) {
        return cache.get(key);
    }

    void put(String key, String value) {
        cache.put(key, value);
    }

}
