package com.irfanirawansukirman.core.ui

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

sealed class UIState<out T : Any> {
    data class Loading(val isLoading: Boolean) : UIState<Nothing>()
    data class Success<out T : Any>(val output: T) : UIState<T>()
    data class Failure(val throwable: Throwable) : UIState<Nothing>()
}

sealed class IOTaskResult<out T : Any> {
    data class OnSuccess<out T : Any>(val data: T) : IOTaskResult<T>()
    data class OnFailed(val throwable: Throwable) : IOTaskResult<Nothing>()
}