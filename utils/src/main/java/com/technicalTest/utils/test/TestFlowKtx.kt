package com.technicalTest.utils.test

import app.cash.turbine.test
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.StateFlow
import kotlin.time.ExperimentalTime

@ExperimentalTime
suspend fun <T> StateFlow<T>.assertItems(
    vararg expectedItems: T,
    trigger: () -> Unit,
) {
    test {
        trigger()
        expectedItems.forEach { item ->
            assertEquals(awaitItem(), item)
        }
        cancelAndConsumeRemainingEvents()
    }
}