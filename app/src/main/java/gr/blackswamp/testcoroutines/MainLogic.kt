package gr.blackswamp.testcoroutines

import kotlinx.coroutines.*

class MainLogic(private val vm: IMainViewModel, private val dispatchers: IDispatchers = AppDispatchers) {
    fun doStuff() {
        vm.clearMessages()
        GlobalScope.launch(dispatchers.UI) {
            vm.showProgress(true)
            
            val jobs = mutableListOf<Job>()
            val time = System.currentTimeMillis()
            vm.addMessage("Started ${Thread.currentThread().name}")
            jobs.add(async(dispatchers.CPU) {
                vm.addMessage("CPU start ${Thread.currentThread().name}")
                heavyCalculation()
                vm.addMessage("CPU end ${Thread.currentThread().name}")
            })
            jobs.add(launch(dispatchers.IO) {
                vm.addMessage("Io start ${Thread.currentThread().name}")
                heavyCalculation()
                vm.addMessage("IO end ${Thread.currentThread().name}")
            })
            vm.addMessage("Finished ${Thread.currentThread().name}")
            joinAll(*jobs.toTypedArray())
            vm.addMessage("Finished in ${System.currentTimeMillis() - time} milliseconds")
            vm.showProgress(false)
        }
        vm.addMessage("Finished executing doStuff")
    }

    private fun heavyCalculation(): Int {
        var counter = 0
        for (i in 0 until 58269602) {
            counter++
        }
        Thread.sleep(3000)
        return counter
    }

}