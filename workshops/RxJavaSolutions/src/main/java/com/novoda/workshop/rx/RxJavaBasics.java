package com.novoda.workshop.rx;

import com.novoda.workshop.rx.observer.IntegerPrinterObserver;
import com.novoda.workshop.rx.observer.StringPrinterObserver;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

import static com.novoda.workshop.rx.Functions.*;

public class RxJavaBasics {

    private static final List<Integer> INTEGERS = Arrays.asList(0, 1, 2, 3, 4, 5, 6);

    /*
        TODO:
        - Multiply all elements by 2
        - Get only even element and multiply them by 2
        - Prepend the string "Integer : " in front of every element
        - Repeat 3 time every element
        - Repeat 3 times every even element only say once odd ones
        - Fail if an element is not even.
        - If an element is not even restart and double the entire sequence
     */

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Observable.from(INTEGERS).filter(isEven()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS)
                .filter(isEven())
                .subscribe(new IntegerPrinterObserver());

        System.out.println("Observable.from(INTEGERS).filter(isEven()).map(multiplyBy2()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS)
                .filter(isEven())
                .map(multiplyBy2())
                .subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).filter(isEven()).map(format()).subscribe(new StringPrinterObserver());");
        Observable.from(INTEGERS)
                .filter(isEven())
                .map(format())
                .subscribe(new StringPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).flatMap(threeTimes()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS)
                .flatMap(threeTimes())
                .subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).flatMap(threeTimesIfEven()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS)
                .flatMap(threeTimesIfEven())
                .subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).flatMap(failIfNotEven()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS)
                .flatMap(failIfNotEven())
                .subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).flatMap(failIfNotEven()).onErrorResumeNext(doubleEverything()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS)
                .flatMap(failIfNotEven())
                .onErrorResumeNext(doubleEverything())
                .subscribe(new IntegerPrinterObserver());
    }

    private static Func1<Throwable, Observable<Integer>> doubleEverything() {
        return new Func1<Throwable, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Throwable throwable) {
                return Observable.from(INTEGERS).map(multiplyBy2());
            }
        };
    }
}
