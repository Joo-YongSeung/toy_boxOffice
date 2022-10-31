package com.greedy.boxoffice

import com.google.gson.annotations.SerializedName
//TMDb API에서 영화를 가져오기 위한 클래스
data class GetMoviesResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int
)