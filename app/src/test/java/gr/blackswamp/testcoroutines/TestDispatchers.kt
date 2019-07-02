package gr.blackswamp.testcoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi

object TestDispatchers : IDispatchers {
    @ExperimentalCoroutinesApi
    override val IO = Dispatchers.Unconfined
    override val UI = Dispatchers.Unconfined
    override val CPU = Dispatchers.Unconfined

}