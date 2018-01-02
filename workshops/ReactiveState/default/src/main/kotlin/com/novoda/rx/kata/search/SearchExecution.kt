package com.novoda.rx.kata.search

import io.reactivex.Observable

interface SearchExecution {

    fun observeExecution(): Observable<ExecutedSearch>

}
