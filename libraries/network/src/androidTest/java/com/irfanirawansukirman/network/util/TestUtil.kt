package com.irfanirawansukirman.network.util

import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

fun getStringFromFile(context: Context, filePath: String?): String? {
    val stream = context.classLoader.getResourceAsStream(filePath)
    var response: String? = null
    try {
        response = convertStreamToString(stream)
        stream.close()
    } catch (e: Exception) {
        Log.e("Error ", e.message ?: "There are something wrong with your test")
    }
    return response
}

@Throws(Exception::class)
fun convertStreamToString(`is`: InputStream?): String {
    val reader = BufferedReader(InputStreamReader(`is`))
    val sb = StringBuilder()
    var line: String?
    while (reader.readLine().also { line = it } != null) {
        sb.append(line).append("\n")
    }
    reader.close()
    return sb.toString()
}