package com.irfanirawansukirman.core.util.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Created by Irfan Irawan Sukirman on 2/9/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

private fun preAndroidMInternetCheck(
    connectivityManager: ConnectivityManager
): Boolean {
    val activeNetwork = connectivityManager.activeNetworkInfo
    if (activeNetwork != null) {
        return (activeNetwork.type == ConnectivityManager.TYPE_WIFI ||
                activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
    }
    return false
}

@RequiresApi(Build.VERSION_CODES.M)
private fun postAndroidMInternetCheck(
    connectivityManager: ConnectivityManager
): Boolean {
    val network = connectivityManager.activeNetwork
    val connection =
        connectivityManager.getNetworkCapabilities(network)

    return connection != null && (
            connection.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    connection.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
}

fun isNetworkAvailable(context: Context): Boolean {
    return try {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as
                    ConnectivityManager

        return if (Build.VERSION.SDK_INT >=
            Build.VERSION_CODES.M
        ) {
            postAndroidMInternetCheck(connectivityManager)
        } else {
            preAndroidMInternetCheck(connectivityManager)
        }
    } catch (e: Exception) { // for testing needs
        true
    }
}