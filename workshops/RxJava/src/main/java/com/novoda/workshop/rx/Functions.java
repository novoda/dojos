package com.novoda.workshop.rx;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import static java.lang.Thread.sleep;

public class Functions {

    public static Observable<String> say(final String what) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("Hello I'm running on thread \"" + Thread.currentThread().getName() + "\" in 3 sec I'll say " + what);
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    subscriber.onError(e);
                }
                subscriber.onNext(what);
            }
        });
    }

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
