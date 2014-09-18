package com.novoda.workshop.rx.observer;

import rx.Observer;

public class StringPrinterObserver implements Observer<String> {
    @Override
    public void onCompleted() {
        System.out.println("onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        System.err.println("Failure " + e);
    }

    @Override
    public void onNext(String string) {
        System.out.println("onNext : " + string);
    }
}
