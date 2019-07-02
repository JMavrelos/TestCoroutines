package gr.blackswamp.testcoroutines

interface IMainViewModel {
    fun clearMessages()
    fun showProgress(show: Boolean)
    fun addMessage(message: String)
//    val newMessage: LiveData<String>
//    val clearMessages: LiveData<Unit>
}