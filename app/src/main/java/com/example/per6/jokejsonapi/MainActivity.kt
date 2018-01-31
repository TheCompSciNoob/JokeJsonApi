package com.example.per6.jokejsonapi

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //LifeCycle Components
        val jokeViewModel = ViewModelProviders.of(this).get(JokeViewModel::class.java)

        //wire widgets
        val jokeAdapter = JokeAdapter(this, jokeViewModel.jokesList)
        recyclerView.adapter = jokeAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //button
        moreJokesButton.setOnClickListener {
            jokeViewModel.requestRandomTen()
        }

        //request for new list on activity start
        if (savedInstanceState == null) jokeViewModel.requestRandomTen()
    }
}