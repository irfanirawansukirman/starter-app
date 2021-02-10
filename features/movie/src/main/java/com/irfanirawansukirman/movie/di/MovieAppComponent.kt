package com.irfanirawansukirman.movie.di

import android.app.Application
import com.irfanirawansukirman.movie.presentation.dashboard.DashboardFragment
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@ExperimentalCoroutinesApi
@Singleton
@Component(modules = [MovieAppModule::class, MovieVMModule::class])
interface MovieAppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MovieAppComponent
    }

    fun inject(dashboardFragment: DashboardFragment)
}