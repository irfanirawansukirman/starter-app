package com.irfanirawansukirman.starterapp

import android.app.Application
import com.irfanirawansukirman.movie.di.DaggerMovieAppComponent
import com.irfanirawansukirman.movie.di.MovieAppComponent
import com.irfanirawansukirman.movie.di.MovieComponentProvider

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

class MainApp : Application(), MovieComponentProvider {

    override fun onCreate() {
        super.onCreate()
    }

    override fun getMovieComponent(): MovieAppComponent {
        return DaggerMovieAppComponent
            .builder()
            .application(this)
            .build()
    }
}