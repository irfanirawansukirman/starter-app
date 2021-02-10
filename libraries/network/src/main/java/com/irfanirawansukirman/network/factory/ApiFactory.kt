package com.irfanirawansukirman.network.factory

import android.content.Context
import com.irfanirawansukirman.network.BuildConfig
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Irfan Irawan Sukirman on 2/7/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

object ApiFactory {

    fun build(
        application: Context,
    ): Retrofit {

        val client = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .pingInterval(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(getChuckIntercept(application))
                    addInterceptor(getHttpLogIntercept())
                    addInterceptor(getChainIntercept())
                }
            }.build()

        return getRetrofit(client)
    }

    private fun getRetrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    private fun getChuckIntercept(appContext: Context) = ChuckInterceptor(appContext)

    private fun getHttpLogIntercept() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private fun getChainIntercept() = { chain: Interceptor.Chain ->
        chain.proceed(
            chain.request().newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .build()
        )
    }

    inline fun <reified T> getService(retrofit: Retrofit): T = retrofit.create(T::class.java)
}