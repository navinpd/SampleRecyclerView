package com.big.recyclerview

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.LinearLayoutManager
import com.big.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf(
            Note("Buddy where you want to go", true),
            Note("Hello what do you do?", true),
            Note("Let's ask for out to girl", false),
            Note("Let's have a cup of tea and dance", false),
            Note("I am working from home and let's do it", false),
            Note("What do you do man let's go out?", false)
        )

        val adapter = NoteAdapter(list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.fab.setOnClickListener {
            list.add(Note("Note7 Hello ", false))
            Log.d("String", "FAB got clicked")
            adapter.notifyItemChanged(list.size - 1)
        }
    }
}