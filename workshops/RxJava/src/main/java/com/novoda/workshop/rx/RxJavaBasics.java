package com.novoda.workshop.rx;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.novoda.workshop.rx.Functions.*;
import static java.lang.Thread.sleep;

public class RxJavaBasics {

    private static final List<String> SENTENCES = Arrays.asList("This is the first sentence","I want those to be enumerated", "How would you ask?", "That is yours to find out!");

    private static final List<Integer> INTEGERS = Arrays.asList(0, 1, 2, 3, 4, 5, 6);

    private static final Iterable<Integer> INFINITE_ITERABLE = new Iterable<Integer>() {
        @Override
        public Iterator<Integer> iterator() {
            return new IntegerIterator();
        }
    };

    private static final String THREAD_NAME = Thread.currentThread().getName();
    private static final Scheduler FAKE_CURRENT_THREAD_SCHEDULER = Schedulers.from(Executors.newSingleThreadExecutor(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, THREAD_NAME);
        }
    }));

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Observable.from(INTEGERS).filter(isEven()).map(multiplyBy2()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS).filter(isEven()).map(multiplyBy2()).subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).filter(isEven()).map(format()).subscribe(new StringPrinterObserver());");
        Observable.from(INTEGERS).filter(isEven()).map(format()).subscribe(new StringPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).flatMap(threeTimes()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS).flatMap(threeTimes()).subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).flatMap(threeTimesIfEven()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS).flatMap(threeTimesIfEven()).subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).flatMap(failIfNotEven()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS).flatMap(failIfNotEven()).subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INTEGERS).flatMap(failIfNotEven()).onErrorResumeNext(doubleEverything()).subscribe(new IntegerPrinterObserver());");
        Observable.from(INTEGERS).flatMap(failIfNotEven()).onErrorResumeNext(doubleEverything()).subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INFINITE_ITERABLE).first().subscribe(new IntegerPrinterObserver());");
        Observable.from(INFINITE_ITERABLE).first().subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.from(INFINITE_ITERABLE).take(20).subscribe(new IntegerPrinterObserver());");
        Observable.from(INFINITE_ITERABLE).take(20).subscribe(new IntegerPrinterObserver());

        System.out.println("\nObservable.zip(Observable.from(SENTENCES), Observable.from(INFINITE_ITERABLE), prepend()).subscribe(new StringPrinterObserver());");
        Observable.zip(Observable.from(SENTENCES), Observable.from(INFINITE_ITERABLE), prepend()).subscribe(new StringPrinterObserver());

        System.out.println("\nObservable.from(SENTENCES).scan(concat()).last().subscribe(new StringPrinterObserver());");
        Observable.from(SENTENCES).scan(concat()).last().subscribe(new StringPrinterObserver());

        System.out.println("\nsay(\"one\").subscribe(new ThreadAwareStringPrinterObserver());");
        System.out.println("say(\"two\").subscribe(new ThreadAwareStringPrinterObserver());");
        say("one").subscribe(new ThreadAwareStringPrinterObserver());
        say("two").subscribe(new ThreadAwareStringPrinterObserver());

        System.out.println("\nsay(\"one\").subscribeOn(Schedulers.computation()).observeOn(FAKE_CURRENT_THREAD_SCHEDULER).subscribe(new ThreadAwareStringPrinterObserver());");
        System.out.println("say(\"two\").subscribeOn(Schedulers.computation()).observeOn(FAKE_CURRENT_THREAD_SCHEDULER).subscribe(new ThreadAwareStringPrinterObserver());");
        say("one").subscribeOn(Schedulers.computation()).observeOn(FAKE_CURRENT_THREAD_SCHEDULER).subscribe(new ThreadAwareStringPrinterObserver());
        say("two").subscribeOn(Schedulers.computation()).observeOn(FAKE_CURRENT_THREAD_SCHEDULER).subscribe(new ThreadAwareStringPrinterObserver());

        sleep(5000);
    }

    private static Func1<Throwable, Observable<Integer>> doubleEverything() {
        return new Func1<Throwable, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Throwable throwable) {
                return Observable.from(INTEGERS).map(multiplyBy2());
            }
        };
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

    private static class IntegerIterator implements Iterator<Integer> {

        Integer counter = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return counter++;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class ThreadAwareStringPrinterObserver extends StringPrinterObserver {
        @Override
        public void onNext(String string) {
            System.out.println("onNext : Got a value on thread \"" + Thread.currentThread().getName() + "\" " + string);
        }
    }
}
