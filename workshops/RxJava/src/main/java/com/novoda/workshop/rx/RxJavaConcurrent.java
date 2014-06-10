package com.novoda.workshop.rx;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import rx.Scheduler;
import rx.schedulers.Schedulers;

import static com.novoda.workshop.rx.Functions.say;
import static java.lang.Thread.sleep;

public class RxJavaConcurrent {

    private static final String THREAD_NAME = Thread.currentThread().getName();
    private static final Scheduler FAKE_CURRENT_THREAD_SCHEDULER = Schedulers.from(Executors.newSingleThreadExecutor(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, THREAD_NAME);
        }
    }));

    /*
        TODO:
        - What is the default execution environment for observable
        - What can you use to change the place execution takes place ? What about the callbacks in the Observer ?
        - What happen if you specify a subscribeOn but not a ObserveOn ?
        - Create an observable that only executes say("two") once say("one") is over.
        - Any questions or crazy ideas ? Now is the time !
     */

    public static void main(String[] args) throws InterruptedException {

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

}
