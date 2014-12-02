package com.novoda.shopping;

import java.util.List;

public class PriceCalculator {

    int getTotalPrice(List<Product> products) {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

}
