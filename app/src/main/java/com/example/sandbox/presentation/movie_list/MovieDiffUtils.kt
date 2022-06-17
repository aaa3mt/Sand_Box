package com.example.sandbox.presentation.movie_list

import androidx.recyclerview.widget.DiffUtil
import com.example.sandbox.presentation.MovieUi

class MovieDiffUtil : DiffUtil.ItemCallback<MovieUi>() {

    override fun areItemsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MovieUi, newItem: MovieUi): Boolean {
        return oldItem == newItem
    }
}