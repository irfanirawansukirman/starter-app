package com.irfanirawansukirman.network.data.response

/**
 * Created by Irfan Irawan Sukirman on 2/7/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

data class BaseResponse<T>(
    val code: Int,
    val message: String,
    val status: String,
    val data: T
)
