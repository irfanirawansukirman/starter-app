package com.irfanirawansukirman.cache

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.irfanirawansukirman.cache.dao.MovieDao
import com.irfanirawansukirman.cache.entity.MovieEntity
import com.irfanirawansukirman.cache.factory.CacheFactory
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@RunWith(AndroidJUnit4::class)
class MoviesTest {

    private lateinit var movieDao: MovieDao
    private lateinit var cacheFactory: CacheFactory

    @Before
    fun setup() {
        val context: Context = ApplicationProvider.getApplicationContext()

        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        cacheFactory = Room.inMemoryDatabaseBuilder(context, CacheFactory::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()

        movieDao = cacheFactory.movieDao()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetMovie() = runBlocking {
        val movie = MovieEntity(1, "", "", 1.0, 1.0)

        movieDao.insert(movie)

        val cache = movieDao.getMovie(movie.id)
        Assert.assertEquals(cache, movie)
    }

    @Test
    @Throws(Exception::class)
    fun getAllMovies() = runBlocking {
        val movie1 = MovieEntity(1, "", "", 1.0, 1.0)
        val movie2 = MovieEntity(2, "", "", 1.0, 1.0)

        movieDao.insert(listOf(movie1, movie2))

        val cache = movieDao.getAllMovies()
        Assert.assertEquals(cache[0], movie1)
        Assert.assertEquals(cache[1], movie2)
    }

    @Test
    @Throws(Exception::class)
    fun updateMovie() = runBlocking {
        val movie1 = MovieEntity(1, "", "", 1.0, 1.0)

        movieDao.insert(movie1)

        val cache = movieDao.getMovie(movie1.id)
        cache.name = "Irfan Irawan Sukirman"

        movieDao.update(cache)

        val cacheUpdate = movieDao.getMovie(cache.id)
        Assert.assertEquals(cacheUpdate.name, cache.name)
    }

    @Test
    @Throws(Exception::class)
    fun deleteAllMovies() = runBlocking {
        val movie1 = MovieEntity(1, "", "", 1.0, 1.0)
        val movie2 = MovieEntity(2, "", "", 1.0, 1.0)

        movieDao.apply {
            insert(listOf(movie1, movie2))
            deleteAllMovies()
        }

        val cache = movieDao.getAllMovies()
        Assert.assertTrue(cache.isEmpty())
    }

    @After
    fun close() {
        cacheFactory.close()
    }
}