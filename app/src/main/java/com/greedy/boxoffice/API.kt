package com.greedy.boxoffice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "012feef45fa4a062d79f2477bcea6b62",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>
}