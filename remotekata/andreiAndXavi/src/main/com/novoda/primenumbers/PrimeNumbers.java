package com.novoda.primenumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    public static List<Integer> generate(int i) {
        if (i == 1) {
            return new ArrayList<Integer>();
        }
        return new ArrayList<Integer>() {{
            add(2);
        }};
    }

}
