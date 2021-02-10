package com.irfanirawansukirman.network.data.response

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize


/**
 * Created by Irfan Irawan Sukirman on 2/8/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */

@Parcelize
@JsonClass(generateAdapter = true)
data class MovieResponse(
  @Json(name = "adult")
  val adult: Boolean?,
  @Json(name = "backdrop_path")
  val backdropPath: String?,
  @Json(name = "belongs_to_collection")
  val belongsToCollection: BelongsToCollection?,
  @Json(name = "budget")
  val budget: Int?,
  @Json(name = "genres")
  val genres: List<Genre>?,
  @Json(name = "homepage")
  val homepage: String?,
  @Json(name = "id")
  val id: Int?,
  @Json(name = "imdb_id")
  val imdbId: String?,
  @Json(name = "original_language")
  val originalLanguage: String?,
  @Json(name = "original_title")
  val originalTitle: String?,
  @Json(name = "overview")
  val overview: String?,
  @Json(name = "popularity")
  val popularity: Double?,
  @Json(name = "poster_path")
  val posterPath: String?,
  @Json(name = "production_companies")
  val productionCompanies: List<ProductionCompany>?,
  @Json(name = "production_countries")
  val productionCountries: List<ProductionCountry>?,
  @Json(name = "release_date")
  val releaseDate: String?,
  @Json(name = "revenue")
  val revenue: Int?,
  @Json(name = "runtime")
  val runtime: Int?,
  @Json(name = "spoken_languages")
  val spokenLanguages: List<SpokenLanguage>?,
  @Json(name = "status")
  val status: String?,
  @Json(name = "tagline")
  val tagline: String?,
  @Json(name = "title")
  val title: String?,
  @Json(name = "video")
  val video: Boolean?,
  @Json(name = "vote_average")
  val voteAverage: Int?,
  @Json(name = "vote_count")
  val voteCount: Int?
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class BelongsToCollection(
  @Json(name = "backdrop_path")
  val backdropPath: String?,
  @Json(name = "id")
  val id: Int?,
  @Json(name = "name")
  val name: String?,
  @Json(name = "poster_path")
  val posterPath: String?
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Genre(
  @Json(name = "id")
  val id: Int?,
  @Json(name = "name")
  val name: String?
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ProductionCompany(
  @Json(name = "id")
  val id: Int?,
  @Json(name = "logo_path")
  val logoPath: String?,
  @Json(name = "name")
  val name: String?,
  @Json(name = "origin_country")
  val originCountry: String?
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ProductionCountry(
  @Json(name = "iso_3166_1")
  val iso31661: String?,
  @Json(name = "name")
  val name: String?
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class SpokenLanguage(
  @Json(name = "english_name")
  val englishName: String?,
  @Json(name = "iso_639_1")
  val iso6391: String?,
  @Json(name = "name")
  val name: String?
) : Parcelable