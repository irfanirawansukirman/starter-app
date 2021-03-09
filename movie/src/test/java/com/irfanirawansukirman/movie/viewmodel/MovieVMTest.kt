package com.irfanirawansukirman.movie.viewmodel

import androidx.lifecycle.Observer
import com.irfanirawansukirman.core.ui.IOTaskResult
import com.irfanirawansukirman.core.ui.UIState
import com.irfanirawansukirman.movie.domain.MovieUseCaseImpl
import com.irfanirawansukirman.movie.presentation.dashboard.DashboardVM
import com.irfanirawansukirman.movie.util.BaseTest
import com.irfanirawansukirman.network.data.response.MoviesData
import com.irfanirawansukirman.network.data.response.MoviesResponse
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test
import org.mockito.ArgumentMatchers

/**
 * Created by Irfan Irawan Sukirman on 2/10/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@ExperimentalCoroutinesApi
class MovieVMTest : BaseTest() {

    private var mockMovieResponse: MoviesResponse = mockk(relaxed = true)

    private var movieObserver: Observer<UIState<List<MoviesData>>> = mockk(relaxed = true)

    // stubbing example
    private var movieUseCaseImpl: MovieUseCaseImpl = mockk(relaxed = true)

    private val fakeSuccessFlow = flow {
        emit(IOTaskResult.OnSuccess(mockMovieResponse))
    }

    private val viewModel: DashboardVM by lazy {
        DashboardVM(context, testCoroutineContextProvider, movieUseCaseImpl)
    }

    @Test
    fun `get movies with success`() = coroutinesRule.runBlockingTest {
        // stubbing test
        coEvery { movieUseCaseImpl.getMovies(any()) } returns fakeSuccessFlow

        viewModel.movies.observeForever(movieObserver)
        viewModel.getMovies(moviesParam())

        verifyOrder {
            viewModel.getMovies(moviesParam())
            movieObserver.onChanged(UIState.Loading(true))
            movieObserver.onChanged(UIState.Success(ArgumentMatchers.anyList()))
            movieObserver.onChanged(UIState.Loading(false))
        }
    }

    @Test
    fun `get movies with failure`() = coroutinesRule.runBlockingTest {
        coEvery { movieUseCaseImpl.getMovies(any()) } returns fakeFailureFlow

        viewModel.movies.observeForever(movieObserver)
        viewModel.getMovies(moviesParam())

        verifyOrder {
            viewModel.getMovies(moviesParam())
            movieObserver.onChanged(UIState.Loading(true))
            movieObserver.onChanged(UIState.Failure(mockException))
            movieObserver.onChanged(UIState.Loading(false))
        }
    }

    @After
    fun `clear all mock and instance`() = coroutinesRule.runBlockingTest {
        viewModel.movies.removeObserver(movieObserver)
        clearAllMocks()
    }

    private fun moviesParam() = HashMap<String, Any>()
}