package com.example;

public class InternetFruitRepository {

    public static final InternetFruitRepository instance = new InternetFruitRepository();

    public Fruit loadFruitFromInternet() {
        return new Fruit("Apple");
    }

}
