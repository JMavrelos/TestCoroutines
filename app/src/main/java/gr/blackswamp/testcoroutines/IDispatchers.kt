package gr.blackswamp.testcoroutines

import kotlinx.coroutines.CoroutineDispatcher

interface IDispatchers {
    val IO: CoroutineDispatcher
    val UI: CoroutineDispatcher
    val CPU : CoroutineDispatcher
}
