package com.irfanirawansukirman.movie.presentation.dashboard

import androidx.recyclerview.widget.RecyclerView
import com.irfanirawansukirman.movie.databinding.MovieItemBinding
import com.irfanirawansukirman.network.data.response.MoviesData

/**
 * Created by Irfan Irawan Sukirman on 2/9/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

class MovieItemHolder(private val viewBinding: MovieItemBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bindItem(movie: MoviesData) {
        viewBinding.tvTitle.text = movie.originalTitle
    }
}