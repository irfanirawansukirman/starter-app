package com.irfanirawansukirman.network.data.service

import com.irfanirawansukirman.network.data.response.MovieResponse
import com.irfanirawansukirman.network.data.response.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * Created by Irfan Irawan Sukirman on 2/7/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */
interface MovieService {

    @GET("movie/popular")
    suspend fun getMovies(@QueryMap param: HashMap<String, Any>): Response<MoviesResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") movieId: Int): Response<MovieResponse>
}