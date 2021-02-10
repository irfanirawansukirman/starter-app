package com.irfanirawansukirman.movie.data.contract

import com.irfanirawansukirman.core.ui.IOTaskResult
import com.irfanirawansukirman.network.data.response.MovieResponse
import com.irfanirawansukirman.network.data.response.MoviesResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

interface IMovieRemoteDataSource {

    val iWebService: IMovieWebService

    suspend fun getMovies(param: HashMap<String, Any>): Flow<IOTaskResult<MoviesResponse>>

    suspend fun getMovie(movieId: Int): Flow<IOTaskResult<MovieResponse>>
}

interface IMovieRepository {

    val iRemoteDataSource: IMovieRemoteDataSource

    suspend fun getMovies(param: HashMap<String, Any>): Flow<IOTaskResult<MoviesResponse>>

    suspend fun getMovie(movieId: Int): Flow<IOTaskResult<MovieResponse>>
}

interface IMovieUseCase {

    interface Movies<in I : Any, out O : Any> {

        suspend fun getMovies(param: I): Flow<IOTaskResult<O>>
    }

    interface Movie<in I : Any, out O : Any> {

        suspend fun getMovie(param: I): Flow<IOTaskResult<O>>
    }
}

interface IMovieWebService {

    suspend fun getMovies(param: HashMap<String, Any>): Flow<IOTaskResult<MoviesResponse>>

    suspend fun getMovie(movieId: Int): Flow<IOTaskResult<MovieResponse>>
}