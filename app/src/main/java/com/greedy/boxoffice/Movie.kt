package com.greedy.boxoffice

import com.google.gson.annotations.SerializedName
//TMDb API에서 영화를 가져오기 위한 클래스
data class Movie (
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("release_date") val releaseDate: String
        )