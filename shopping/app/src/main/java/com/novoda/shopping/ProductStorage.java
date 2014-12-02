package com.novoda.shopping;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductStorage implements Storage<Product> {

    private static final long SHORT_TIME = 1000;
    private static final long LONG_TIME = 5000;

    private static final List<Product> PRODUCTS = new ArrayList<Product>() {{
//        add(new Product());
    }};

    @Override
    public List<Product> retrieveAll() {
        SystemClock.sleep(new Random().nextInt() % 2 == 0 ? SHORT_TIME : LONG_TIME);
        return PRODUCTS;
    }

}
