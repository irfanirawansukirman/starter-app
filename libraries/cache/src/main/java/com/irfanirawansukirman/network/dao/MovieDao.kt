package com.irfanirawansukirman.network.dao

import androidx.room.Dao
import androidx.room.Query
import com.irfanirawansukirman.network.base.BaseDao
import com.irfanirawansukirman.network.entity.MovieEntity

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@Dao
interface MovieDao : BaseDao<MovieEntity> {

    @Query("SELECT * FROM tb_movie where id = :id")
    fun getMovie(id: Int): MovieEntity

    @Query("SELECT * FROM tb_movie ORDER BY name ASC")
    fun getAllMovies(): List<MovieEntity>

    @Query("DELETE FROM tb_movie")
    suspend fun deleteAllMovies()
}