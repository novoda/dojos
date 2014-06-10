package com.novoda.workshop.rx;

import rx.functions.Func1;

public class Functions {

    public static Func1<Integer, Boolean> isEven() {
        return new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return isEven(integer);
            }
        };
    }

    private static boolean isEven(Integer integer) {
        return (integer % 2) == 0;
    }
}
