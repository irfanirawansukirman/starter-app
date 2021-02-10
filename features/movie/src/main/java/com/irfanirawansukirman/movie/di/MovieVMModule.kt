package com.irfanirawansukirman.movie.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irfanirawansukirman.core.util.viewmodel.ViewModelFactory
import com.irfanirawansukirman.core.util.viewmodel.ViewModelKey
import com.irfanirawansukirman.movie.presentation.dashboard.DashboardVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */
@ExperimentalCoroutinesApi
@Module
abstract class MovieVMModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DashboardVM::class)
    internal abstract fun bindDashboardVM(viewModel: DashboardVM): ViewModel
}