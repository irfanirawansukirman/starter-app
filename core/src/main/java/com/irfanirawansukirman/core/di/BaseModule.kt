package com.irfanirawansukirman.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.irfanirawansukirman.core.util.coroutine.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@Module
class BaseModule {

    @Singleton
    @Provides
    fun provideCoroutineContextProvider(): CoroutineContextProvider = CoroutineContextProvider()

    @Singleton
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences =
        application.getSharedPreferences("starter_app_cache", Context.MODE_PRIVATE)
}