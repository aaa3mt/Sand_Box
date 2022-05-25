package com.example.sandbox.presentation.movie_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.sandbox.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_details.*

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    private val titleText get() = movie_details_title
    private val ratingText get() = movie_details_rating
    private val descriptionText get() = movie_details_description
    private val movieImage get() = movie_details_image

    private val args: MovieDetailsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }
    private fun initView ( ){
        titleText.text = args.movie.title
        ratingText.text = args.movie.rating.toString()
        descriptionText.text = args.movie.description
        Picasso.get().load(args.movie.imageUrl).placeholder(org.koin.android.R.drawable.abc_ic_star_black_48dp).error(
            org.koin.android.R.drawable.abc_ic_star_half_black_48dp).into(movieImage)
    }

}