package com.novoda.workshop.contributors

import kotlinx.coroutines.CoroutineDispatcher

internal data class DispatcherStrategy(val ui : CoroutineDispatcher, val work : CoroutineDispatcher)
