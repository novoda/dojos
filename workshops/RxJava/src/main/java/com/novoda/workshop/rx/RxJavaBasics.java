package com.novoda.workshop.rx;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Observer;

import static com.novoda.workshop.rx.Functions.isEven;

public class RxJavaBasics {

    private static final List<Integer> INTEGERS = Arrays.asList(0, 1, 2, 3, 4, 5, 6);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Observable.from(INTEGERS).filter(isEven()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS).filter(isEven()).subscribe(new IntegerPrinterObserver());

    }

    private static class IntegerPrinterObserver implements Observer<Integer> {
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

    private static class StringPrinterObserver implements Observer<String> {
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
}
