package com.tobi.movies.misc;

import rx.Observer;

public abstract class AbstractObserver<T> implements Observer<T> {
    @Override
    public void onCompleted() {
        //no-op
    }

    @Override
    public void onError(Throwable e) {
        //no-op
    }

    @Override
    public void onNext(T t) {
        //no-op
    }
}
