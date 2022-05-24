package com.example.sandbox.presentation.movie_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.sandbox.R
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment: Fragment(R.layout.fragment_movie_list) {

    private val recyclerView get () = movie_list_recycler
    private val adapter = MovieListAdapter()

    private val viewModel = MovieListViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = adapter
        startObserving()

    }

    private fun startObserving() {
        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}