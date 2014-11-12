package com.novoda.workshop.rx.observer;

import rx.Observer;

public class IntegerPrinterObserver implements Observer<Integer> {
    @Override
    public void onCompleted() {
        System.out.println("onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        System.err.println("Failure " + e);
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("onNext : " + integer);
    }
}
