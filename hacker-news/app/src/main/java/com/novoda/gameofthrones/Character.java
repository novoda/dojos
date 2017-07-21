package com.novoda.gameofthrones;

public class Character {
    private final String name;
    private final String wikipediaUrl;

    public Character(String name, String wikipediaUrl) {
        this.name = name;
        this.wikipediaUrl = wikipediaUrl;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public String getName() {
        return name;
    }
}
