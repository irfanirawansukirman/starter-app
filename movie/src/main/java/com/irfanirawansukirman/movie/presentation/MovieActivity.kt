package com.irfanirawansukirman.movie.presentation

import android.os.Bundle
import com.irfanirawansukirman.core.base.BaseActivity
import com.irfanirawansukirman.movie.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MovieActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_activity)
    }
}