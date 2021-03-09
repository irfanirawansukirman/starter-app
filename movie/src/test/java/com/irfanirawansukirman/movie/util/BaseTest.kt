package com.irfanirawansukirman.movie.util

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.irfanirawansukirman.core.ui.IOTaskResult
import com.irfanirawansukirman.core.util.coroutine.TestCoroutineContextProvider
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Rule

@ExperimentalCoroutinesApi
abstract class BaseTest {

    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    val testCoroutineContextProvider = TestCoroutineContextProvider()

    var mockException: Exception = mockk(relaxed = true)

    var context: Application = mockk(relaxed = true)

    val fakeFailureFlow = flow {
        emit(IOTaskResult.OnFailed(mockException))
    }
}