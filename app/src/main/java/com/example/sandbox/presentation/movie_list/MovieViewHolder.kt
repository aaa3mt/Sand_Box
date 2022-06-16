package com.example.sandbox.presentation.movie_list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sandbox.R
import com.example.sandbox.domain.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieViewHolder(itemView: View, private val onItemClick: (Movie) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val container get() = itemView.movie_item_container
    private val movieImage get() = itemView.movie_item_image
    private val movieTitle get() = itemView.movie_item_title
    private val movieRating get() = itemView.movie_item_rating


    fun bind(movie: Movie) {
        movieTitle.text = movie.title
        movieRating.text = movie.rating.toString()
        Glide.with(itemView.context).load(movie.imageUrl)
            .into(movieImage)

        container.setOnClickListener {
            onItemClick(movie)
        }
    }


}