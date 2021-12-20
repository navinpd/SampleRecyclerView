package com.big.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.big.recyclerview.databinding.NoteAdapterBinding

class NoteAdapter(
    var listItems: List<Note>
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private lateinit var context: Context

    inner class NoteViewHolder(val binding: NoteAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        context = parent.context
        val binding = NoteAdapterBinding.inflate(layoutInflater, parent, false)
        Log.d("String", "I got onCreateViewHolder")
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.apply {
            noteText.text = listItems[position].title
            checkBox.isChecked = listItems[position].isChecked
            Log.d("String", "This item is loaded at $position")

            noteText.setOnClickListener {
                Toast.makeText(context, "Hello $position", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = listItems.size

}
