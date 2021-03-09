package com.irfanirawansukirman.movie.data.service

import com.irfanirawansukirman.core.ui.IOTaskResult
import com.irfanirawansukirman.core.util.coroutine.CoroutineContextProvider
import com.irfanirawansukirman.movie.data.contract.IMovieWebService
import com.irfanirawansukirman.network.data.response.MovieResponse
import com.irfanirawansukirman.network.data.response.MoviesResponse
import com.irfanirawansukirman.network.data.service.MovieService
import com.irfanirawansukirman.network.util.performSafeNetworkApiCall
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@ExperimentalCoroutinesApi
@Singleton
class MovieServiceImpl @Inject constructor(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val apiService: MovieService
) : IMovieWebService {

    override suspend fun getMovies(param: HashMap<String, Any>): Flow<IOTaskResult<MoviesResponse>> =
        performSafeNetworkApiCall(coroutineContextProvider) {
            apiService.getMovies(param)
        }

    override suspend fun getMovie(movieId: Int): Flow<IOTaskResult<MovieResponse>> =
        performSafeNetworkApiCall(coroutineContextProvider) {
            apiService.getMovie(movieId)
        }
}