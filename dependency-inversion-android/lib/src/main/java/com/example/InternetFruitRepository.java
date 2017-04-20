package com.example;

public class InternetFruitRepository {

    public static final InternetFruitRepository instance = new InternetFruitRepository();

    public Fruit loadFruitFromInternet() {
        // This internet is slow and unreliable... just like the real thing!
        pretendToBeSlowInternet();
        if (Math.random() < 0.3) {
            return null;
        } else {
            return new Fruit("Apple");
        }
    }

    private void pretendToBeSlowInternet() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
