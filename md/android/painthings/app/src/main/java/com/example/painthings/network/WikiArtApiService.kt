package com.example.painthings.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiArtApiService {
    @GET("painting")
    suspend fun getPaintingDetails(@Query("id") id: String): WikiArtDetailResponse
}