package gr.blackswamp.testcoroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

import org.junit.Before
import org.mockito.Matchers
import org.mockito.Mockito.*

class MainLogicTest {
    lateinit var logic: MainLogic
    lateinit var vm: IMainViewModel

    @Before
    fun setUp() {
        vm = mock(IMainViewModel::class.java)
        logic = MainLogic(vm, TestDispatchers)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testStuff() {
        logic.doStuff()
        verify(vm, times(8)).addMessage(Matchers.anyString())
        println("finished")
    }
}
