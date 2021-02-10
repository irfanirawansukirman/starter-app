package com.irfanirawansukirman.network.factory

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceFactory @Inject constructor(val sharedPreferences: SharedPreferences) {

    fun clearPreferences() {
        sharedPreferences.edit().clear().apply()
    }

    /**
     * finds value on given key.
     * [T] is the type of value
     * @param defaultValue optional default value - will take null for strings, false for bool and -1 for numeric values if [defaultValue] is not specified
     */
    inline operator fun <reified T : Any?> get(key: String, defaultValue: T? = null): T? =
        when (T::class) {
            String::class -> sharedPreferences.getString(
                key,
                defaultValue as? String ?: defaultValue as? String
            ) as? T?
            Int::class -> sharedPreferences.getInt(key, defaultValue as? Int ?: -1) as? T?
            Boolean::class -> sharedPreferences.getBoolean(
                key,
                defaultValue as? Boolean ?: false
            ) as? T?
            Float::class -> sharedPreferences.getFloat(key, defaultValue as? Float ?: -1F) as? T?
            Long::class -> sharedPreferences.getLong(key, defaultValue as? Long ?: -1L) as? T?
            else -> throw UnsupportedOperationException("Pref factory get not yet implemented")
        }

    private inline fun SharedPreferences.edit(operation: SharedPreferences.Editor.() -> Unit) {
        edit().apply {
            operation(this)
            apply()
        }
    }

    /**
     * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
     */
    operator fun set(key: String, value: Any?) {
        sharedPreferences.apply {
            when (value) {
                is String? -> edit { putString(key, value) }
                is Int -> edit { putInt(key, value) }
                is Boolean -> edit { putBoolean(key, value) }
                is Float -> edit { putFloat(key, value) }
                is Long -> edit { putLong(key, value) }
                else -> throw UnsupportedOperationException("Pref factory set not yet implemented")
            }
        }
    }
}