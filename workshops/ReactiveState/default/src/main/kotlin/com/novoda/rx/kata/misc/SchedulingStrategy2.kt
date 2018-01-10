package com.novoda.rx.kata.misc

import io.reactivex.Scheduler
import io.reactivex.SingleTransformer
import io.reactivex.schedulers.Schedulers

class SchedulingStrategy2(val executor: Scheduler, val notifier: Scheduler) {

    fun <T> applyToSingle(): SingleTransformer<T, T> {
        return SingleTransformer { single ->
            single
                    .subscribeOn(executor)
                    .observeOn(notifier)
        }
    }

    companion object {

        fun immediate(): SchedulingStrategy2 {
            return SchedulingStrategy2(Schedulers.trampoline(), Schedulers.trampoline())
        }
    }
}
