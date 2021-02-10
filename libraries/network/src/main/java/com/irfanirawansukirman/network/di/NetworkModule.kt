package com.irfanirawansukirman.network.di

import android.app.Application
import com.irfanirawansukirman.network.factory.ApiFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Irfan Irawan Sukirman on 2/7/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(application: Application): Retrofit = ApiFactory.build(application)
}