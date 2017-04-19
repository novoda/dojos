package com.example;

public class CachingFruitFetcher {

    Fruit fetchFruit() {
        if (Preferences.instance.valueForKey("lastFruit") != null) {
            return new Fruit("banana");
        } else {
            return InternetFruitRepository.instance.loadFruitFromInternet();
        }
    }

}
