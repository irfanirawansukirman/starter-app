package com.irfanirawansukirman.movie.di

import com.irfanirawansukirman.core.di.BaseModule
import com.irfanirawansukirman.core.util.coroutine.CoroutineContextProvider
import com.irfanirawansukirman.movie.data.network.MovieNetworkDataSource
import com.irfanirawansukirman.movie.data.contract.IMovieRemoteDataSource
import com.irfanirawansukirman.movie.data.contract.IMovieRepository
import com.irfanirawansukirman.movie.data.contract.IMovieWebService
import com.irfanirawansukirman.movie.data.network.repository.MovieRepositoryImpl
import com.irfanirawansukirman.movie.data.service.MovieServiceImpl
import com.irfanirawansukirman.movie.domain.MovieUseCaseImpl
import com.irfanirawansukirman.network.data.service.MovieService
import com.irfanirawansukirman.network.di.NetworkModule
import com.irfanirawansukirman.network.factory.ApiFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@ExperimentalCoroutinesApi
@Module(includes = [BaseModule::class, NetworkModule::class])
class MovieAppModule {

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService = ApiFactory.getService(retrofit)

    @Provides
    fun provideMovieWebService(
        coroutineContextProvider: CoroutineContextProvider,
        movieService: MovieService
    ): IMovieWebService = MovieServiceImpl(coroutineContextProvider, movieService)

    @Provides
    fun provideMovieNetworkDataSource(iMovieWebService: IMovieWebService): IMovieRemoteDataSource =
        MovieNetworkDataSource(iMovieWebService)

    @Provides
    fun provideMovieRepositoryImpl(movieNetworkDataSource: MovieNetworkDataSource): IMovieRepository =
        MovieRepositoryImpl(movieNetworkDataSource)

    @Provides
    fun provideMovieUseCaseImpl(iMovieRepository: IMovieRepository): MovieUseCaseImpl =
        MovieUseCaseImpl(iMovieRepository)
}