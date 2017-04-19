package com.example;

public class Preferences {

    public static final Preferences instance = new Preferences();

    String valueForKey(String key) {
        if (key.equals("lastFruit")) {
            return "Banana";
        } else {
            return null;
        }
    }

}
