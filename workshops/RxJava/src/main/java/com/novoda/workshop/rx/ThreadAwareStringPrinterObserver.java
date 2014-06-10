package com.novoda.workshop.rx;

import com.novoda.workshop.rx.observer.StringPrinterObserver;

public class ThreadAwareStringPrinterObserver extends StringPrinterObserver {
    @Override
    public void onNext(String string) {
        System.out.println("onNext : Got a value on thread \"" + Thread.currentThread().getName() + "\" " + string);
    }
}
