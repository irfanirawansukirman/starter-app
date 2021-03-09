package com.irfanirawansukirman.movie.data.network

import com.irfanirawansukirman.core.ui.IOTaskResult
import com.irfanirawansukirman.movie.data.contract.IMovieRemoteDataSource
import com.irfanirawansukirman.movie.data.contract.IMovieWebService
import com.irfanirawansukirman.network.data.response.MovieResponse
import com.irfanirawansukirman.network.data.response.MoviesResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@Singleton
class MovieNetworkDataSource @Inject constructor(override val iWebService: IMovieWebService) :
    IMovieRemoteDataSource {

    override suspend fun getMovies(param: HashMap<String, Any>): Flow<IOTaskResult<MoviesResponse>> = iWebService.getMovies(param)

    override suspend fun getMovie(movieId: Int): Flow<IOTaskResult<MovieResponse>> = iWebService.getMovie(movieId)
}