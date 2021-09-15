package com.daniillyubaev.ourawesomeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.daniillyubaev.ourawesomeapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val viewModel: MainViewModel by viewModels()
    private val viewBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = setupRecyclerView()

        findViewById<View>(R.id.usersRecyclerView).isVisible = false
        findViewById<View>(R.id.progressBar).isVisible = true
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                adapter.userList = loadUsers()
                adapter.notifyDataSetChanged()
                findViewById<View>(R.id.usersRecyclerView).isVisible = true
                findViewById<View>(R.id.progressBar).isVisible = false
            }
        }
    }

    private fun setupRecyclerView(): UserAdapter {
        val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclerView)
        val adapter = UserAdapter()
        recyclerView.adapter = adapter
        return adapter
    }

}