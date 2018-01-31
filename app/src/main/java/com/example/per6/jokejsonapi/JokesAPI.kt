package com.example.per6.jokejsonapi

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by per6 on 1/29/18.
 */
interface JokesAPI {

    @GET("random_ten")
    fun getRandomJokes() : Call<List<Joke>>
}