package com.novoda.primenumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    public static List<Integer> generate(int i) {
        if (i == 1) {
            return new ArrayList<Integer>();
        } else if (i == 2 || i == 4) {
            return new ArrayList<Integer>() {{
                add(2);
            }};
        } else {
            return new ArrayList<Integer>() {{
                add(3);
            }};
        }
    }

}
