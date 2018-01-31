package com.example.per6.jokejsonapi

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //LifeCycle Components
        val jokeViewModel = ViewModelProviders.of(this).get(JokeViewModel::class.java)

        //wire widgets
        val jokeAdapter = JokeAdapter(jokeViewModel.jokesList.value!!)
        recyclerView.adapter = jokeAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //observer for data changes
        jokeViewModel.jokesList.observe(this, Observer<List<Joke>> {
            jokeAdapter.jokes = it!!
            jokeAdapter.notifyDataSetChanged()
        })

        //button
        moreJokesButton.setOnClickListener {
            jokeViewModel.requestRandomTen()
        }

        //request for new list on activity start
        if (savedInstanceState == null) jokeViewModel.requestRandomTen()
    }
}