package com.example;

public class CachingFruitFetcher {

    Fruit fetchFruit() {
        if (Preferences.instance.valueForKey("lastFruit") != null) {
            return new Fruit(Preferences.instance.valueForKey("lastFruit"));
        } else {
            Fruit fruit = InternetFruitRepository.instance.loadFruitFromInternet();
            Preferences.instance.put("lastFruit", fruit.getName());
            return fruit;
        }
    }

}
