package gr.blackswamp.testcoroutines

import android.provider.Settings
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

object AppDispatchers : IDispatchers{
    override val IO = Dispatchers.IO
    override val UI= Dispatchers.Main
    override val CPU = Dispatchers.Default


}