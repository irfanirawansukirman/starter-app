package com.irfanirawansukirman.core.util.extension

import android.content.res.Resources
import android.util.TypedValue

/**
 * Created by Irfan Irawan Sukirman on 2/9/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

fun <T> T?.orDefault(default: T): T {
    return this ?: default
}
