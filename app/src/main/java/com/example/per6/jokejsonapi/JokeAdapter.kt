package com.example.per6.jokejsonapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by per6 on 1/29/18.
 */
class JokeAdapter(var jokes : List<Joke>) : RecyclerView.Adapter<JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): JokeViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val rootView = inflater.inflate(R.layout.joke_card_view_layout, parent, false)
        return JokeViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: JokeViewHolder?, position: Int) {
        holder?.bind(jokes[position])
    }
}