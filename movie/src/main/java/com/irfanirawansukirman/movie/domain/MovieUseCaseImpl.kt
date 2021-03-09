package com.irfanirawansukirman.movie.domain

import com.irfanirawansukirman.core.ui.IOTaskResult
import com.irfanirawansukirman.movie.data.contract.IMovieRepository
import com.irfanirawansukirman.movie.data.contract.IMovieUseCase
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
class MovieUseCaseImpl @Inject constructor(private val iRepository: IMovieRepository) :
    IMovieUseCase.Movies<HashMap<String, Any>, MoviesResponse>,
    IMovieUseCase.Movie<Int, MovieResponse> {

    override suspend fun getMovies(param: HashMap<String, Any>): Flow<IOTaskResult<MoviesResponse>> =
        iRepository.getMovies(param)

    override suspend fun getMovie(param: Int): Flow<IOTaskResult<MovieResponse>> =
        iRepository.getMovie(param)
}