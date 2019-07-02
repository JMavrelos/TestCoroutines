package gr.blackswamp.testcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(), IMainViewModel {


    private val logic: MainLogic = MainLogic(this, AppDispatchers)
    private val messageList = mutableListOf<String>()
    val messages = MutableLiveData<List<String>>()
    //    override val newMessage = SingleLiveEvent<String>()
//    override val clearMessages = SingleLiveEvent<Unit>()
    val progress = MutableLiveData<Boolean>()

    override fun addMessage(message: String) {
        messageList.add(message)
//        newMessage.postValue(message)
        messages.postValue(messageList)
    }

    override fun clearMessages() {
        messageList.clear()
//        clearMessages.postValue(null)
        messages.postValue(messageList)
    }

    override fun showProgress(show: Boolean) {
        progress.postValue(show)
    }

    fun test() = logic.doStuff()
}

