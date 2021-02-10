package com.irfanirawansukirman.movie.presentation.dashboard

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.irfanirawansukirman.core.base.BaseVM
import com.irfanirawansukirman.core.ui.UIState
import com.irfanirawansukirman.core.util.coroutine.CoroutineContextProvider
import com.irfanirawansukirman.core.util.extension.orDefault
import com.irfanirawansukirman.movie.domain.MovieUseCaseImpl
import com.irfanirawansukirman.network.data.response.MoviesData
import com.irfanirawansukirman.network.util.getViewStateFlowForNetworkCall
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@ExperimentalCoroutinesApi
class DashboardVM @Inject constructor(
    context: Application,
    private val coroutineContextProvider: CoroutineContextProvider,
    private val movieUseCaseImpl: MovieUseCaseImpl
) : BaseVM(context, coroutineContextProvider) {

    private val _movies = MutableLiveData<UIState<List<MoviesData>>>()
    val movies: LiveData<UIState<List<MoviesData>>>
        get() = _movies

    fun getMovies(param: HashMap<String, Any>) {
        executeJob {
            getViewStateFlowForNetworkCall(coroutineContextProvider) {
                movieUseCaseImpl.getMovies(param)
            }.collect {
                switchToMain {
                    when (it) {
                        is UIState.Loading -> _movies.value = it
                        is UIState.Success -> _movies.value = UIState.Success(
                            it.output.results.orDefault(emptyList())
                        )
                        is UIState.Failure -> _movies.value = it
                    }
                }
            }
        }
    }
}

