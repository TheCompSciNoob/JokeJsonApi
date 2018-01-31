package com.example.per6.jokejsonapi

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.joke_card_view_layout.view.*

/**
 * Created by per6 on 1/29/18.
 */
class JokeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun bind(joke : Joke) = with(itemView) {
        itemView.type.text = joke.type
        itemView.setUp.text = joke.setup
        itemView.punchline.text = joke.punchline
    }
}