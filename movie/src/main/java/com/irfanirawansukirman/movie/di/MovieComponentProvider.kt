package com.irfanirawansukirman.movie.di

import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@ExperimentalCoroutinesApi
interface MovieComponentProvider {

    fun getMovieComponent(): MovieAppComponent
}