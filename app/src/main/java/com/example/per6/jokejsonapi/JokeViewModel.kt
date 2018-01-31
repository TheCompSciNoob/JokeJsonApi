package com.example.per6.jokejsonapi

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by per6 on 1/31/18.
 */
class JokeViewModel : ViewModel() {

    val jokesList: MutableLiveData<List<Joke>> = MutableLiveData()
    val url = "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/"
    val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val api = retrofit.create(JokesAPI::class.java)

    init {
        jokesList.value = arrayListOf()
    }

    fun requestRandomTen() {
        val call = api.getRandomJokes()
        call.enqueue(object : Callback<List<Joke>> {

            override fun onFailure(call: Call<List<Joke>>?, t: Throwable?) {
                throw t!!
            }

            override fun onResponse(call: Call<List<Joke>>?, response: Response<List<Joke>>?) {
                if (response?.body() == null) Log.d("JokeViewModel", "response is null")
                jokesList.value = response?.body()
            }

        })
    }
}