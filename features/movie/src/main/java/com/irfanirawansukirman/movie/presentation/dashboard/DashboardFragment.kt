package com.irfanirawansukirman.movie.presentation.dashboard

import android.os.Bundle
import android.view.View
import com.irfanirawansukirman.core.base.BaseFragment
import com.irfanirawansukirman.core.ui.UIState
import com.irfanirawansukirman.core.util.extension.generateVerticalAdapter
import com.irfanirawansukirman.movie.databinding.DashboardFragmentBinding
import com.irfanirawansukirman.movie.databinding.MovieItemBinding
import com.irfanirawansukirman.movie.di.MovieComponentProvider
import com.irfanirawansukirman.network.data.response.MoviesData
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@ExperimentalCoroutinesApi
class DashboardFragment :
    BaseFragment<DashboardFragmentBinding, DashboardVM>(DashboardFragmentBinding::inflate) {

    private val movieAdapter by lazy {
        viewBinding.rvMovies.generateVerticalAdapter<MoviesData, MovieItemHolder, MovieItemBinding>(
            viewHolder = ::MovieItemHolder,
            bindingInflater = MovieItemBinding::inflate,
            hasFixedSize = true,
            reverseLayout = false,
            binder = { item, holder, _, _ -> holder.bindItem(item) }
        )
    }

    override fun onLoadVM(viewModel: DashboardVM) {
        viewModel.movies.observe(this) {
            when (it) {
                is UIState.Success -> movieAdapter.submitList(it.output)
            }
        }
    }

    override fun getViewModel() = DashboardVM::class.java

    override fun initInjector() {
        (getApplication() as MovieComponentProvider)
            .getMovieComponent()
            .inject(this)
    }

    override fun initComponent() {}

    override fun initViewListener() {}

    override fun onViewReady(savedInstanceState: Bundle?, view: View) {
        val param = HashMap<String, Any>().apply { put("api_key", "Your API Key") }
        viewModel.getMovies(param)
    }

    override fun onClear() {}
}