package com.irfanirawansukirman.core.util.coroutine

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
    open val io: CoroutineContext by lazy { Dispatchers.IO }
    open val default: CoroutineContext by lazy { Dispatchers.Default }
    open val unconfined: CoroutineContext by lazy { Dispatchers.Unconfined }
}

class TestCoroutineContextProvider : CoroutineContextProvider() {
    override val main: CoroutineContext
        get() = Dispatchers.Unconfined

    override val io: CoroutineContext
        get() = Dispatchers.Unconfined

    override val default: CoroutineContext
        get() = Dispatchers.Unconfined

    override val unconfined: CoroutineContext
        get() = Dispatchers.Unconfined
}