package com.greedy.boxoffice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    // 인기있는 영화 목록, 뒤에 language=ko-KR을 붙여줘서 제목, 영화 설명이 한글로 나옴
    @GET("movie/popular?language=ko-KR')")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "012feef45fa4a062d79f2477bcea6b62", // TMDB 내 key값
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    // 별점 높은 영화 목록
    @GET("movie/top_rated?language=ko-KR')")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "012feef45fa4a062d79f2477bcea6b62",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    // 곧 개봉하는 영화 목록
    @GET("movie/upcoming?language=ko-KR')")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "012feef45fa4a062d79f2477bcea6b62",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>
}