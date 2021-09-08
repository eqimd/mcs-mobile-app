package com.daniillyubaev.ourawesomeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)
        val adapter = UserAdapter()
        recyclerView.adapter = adapter
        adapter.userList = loadUsers()
        adapter.notifyDataSetChanged()
    }

    private fun loadUsers(): List<User> {
        return listOf (
            User(
                avatarUrl = "",
                userName = "Kil de rial",
                groupName = "Школа колбасы"
            ),
            User(
                avatarUrl = "",
                userName = "Jorik",
                groupName = "Школа колбасы"
            ),
            User(
                avatarUrl = "",
                userName = "Den4ik",
                groupName = "Школа колбасы"
            ),
            User(
                avatarUrl = "",
                userName = "Dan4ik",
                groupName = "Школа колбасы"
            ),
                )
    }

}