package com.example.sandbox.presentation.movie_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sandbox.presentation.MovieUi
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieViewHolder(itemView: View, private val onItemClick: (MovieUi) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val container get() = itemView.movie_item_container
    private val movieImage get() = itemView.movie_item_image
    private val movieTitle get() = itemView.movie_item_title
    private val movieRating get() = itemView.movie_item_rating


    fun bind(movieUi: MovieUi) {
        movieTitle.text = movieUi.title
        movieRating.text = movieUi.rating.toString()
        Glide.with(itemView.context).load(movieUi.imageUrl)
            .into(movieImage)

        container.setOnClickListener {
            onItemClick(movieUi)
        }
    }


}