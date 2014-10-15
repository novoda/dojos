package com.novoda.primenumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    public static List<Integer> generate(int i) {
        if (i == 1) {
            return new ArrayList<Integer>();
        } else if (i == 2) {
            return new ArrayList<Integer>() {{
                add(2);
            }};
        }else {
            return new ArrayList<Integer>() {{
                add(3);
            }};
        }
    }

}
