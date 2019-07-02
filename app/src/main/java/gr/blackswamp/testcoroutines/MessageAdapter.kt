package gr.blackswamp.testcoroutines

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(messageList: List<String>?) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    private val mMessages = mutableListOf<String>()

    init {
        if (messageList != null) {
            mMessages.addAll(messageList)
        }
    }

    fun clear() {
        val size = mMessages.size
        Log.d("Messages", "current size $size")
        mMessages.clear()
        Log.d("Messages", "new size ${mMessages.size}")
//        notifyItemRangeRemoved(0, size - 1)
        notifyDataSetChanged()
    }

    fun addMessage(message: String) {
        Log.d("Messages", "before add ${mMessages.size}")
        mMessages.add(message)
        Log.d("Messages", "Add $message at ${mMessages.size - 1}")
        notifyItemInserted(mMessages.size - 1)
        Log.d("Messages", "Finished notify")
    }

    override fun getItemCount(): Int = mMessages.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        Log.d("Messages", "create view holder called")
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        Log.d("Messages", "update called for $position")
        holder.update(mMessages[position])
    }

    fun setMessages(messages: List<String>?) {
        mMessages.clear()
        if (messages != null) {
            mMessages.addAll(messages)
        }
        notifyDataSetChanged()
    }

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = view as TextView
        fun update(message: String) {
            text.text = message
        }
    }
}