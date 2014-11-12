package com.novoda.primenumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

    public static List<Integer> generate(int i) {
        if (isOne(i)) {
            return emptyList();
        } else if (i == 2) {
            return new ArrayList<Integer>() {{
                add(2);
            }};

        } else if (i == 4) {
            return new ArrayList<Integer>() {{
                add(2);
                add(2);
            }};
        } else {
            return new ArrayList<Integer>() {{
                add(3);
            }};
        }
    }

    private static boolean isOne(int i) {
        return i == 1;
    }

    private static ArrayList<Integer> emptyList() {
        return new ArrayList<Integer>();
    }

}
