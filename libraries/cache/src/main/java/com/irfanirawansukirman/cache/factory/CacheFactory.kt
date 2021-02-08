package com.irfanirawansukirman.cache.factory

import androidx.room.Database
import androidx.room.RoomDatabase
import com.irfanirawansukirman.cache.dao.MovieDao
import com.irfanirawansukirman.cache.entity.MovieEntity

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class CacheFactory : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}