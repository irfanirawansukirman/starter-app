package com.irfanirawansukirman.cache.di

import android.app.Application
import androidx.room.Room
import com.irfanirawansukirman.cache.dao.MovieDao
import com.irfanirawansukirman.cache.factory.CacheFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@Module
class CacheModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideCacheFactory(): CacheFactory = Room
        .databaseBuilder(application, CacheFactory::class.java, "db_starter_app")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideMovieDao(cacheFactory: CacheFactory): MovieDao = cacheFactory.movieDao()
}