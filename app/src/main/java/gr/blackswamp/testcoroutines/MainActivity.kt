package gr.blackswamp.testcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainViewModel
    private lateinit var adapter: MessageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)
        adapter = MessageAdapter(null) //vm.messageList)
        messages.adapter = adapter
        setUpObservers()
        setUpListeners()
    }

    private fun setUpListeners() {
        button.setOnClickListener { buttonClicked() }
    }

    private fun setUpObservers() {
//        vm.clearMessages.observe(this, Observer {
//            adapter.clear()
//        })
//        vm.newMessage.observe(this, Observer {
//            adapter.addMessage(it)
//        })
        vm.messages.observe(this, Observer {
            adapter.setMessages(it)
        })
        vm.progress.observe(this, Observer {
            Log.d("Main", "Progress $it")
            if (it) {

                progress.show()
                button.hide()
            } else {
                progress.hide()
                button.show()
            }
        })
    }

    private fun buttonClicked() =
        vm.test()

}

