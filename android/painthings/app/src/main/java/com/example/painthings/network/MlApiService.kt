package com.example.painthings.network

import com.example.painthings.emotions.Emotions
import retrofit2.Call
import retrofit2.http.*

interface MlApiService {
    @POST("predict")
    fun predictCluster(
        @Body emotions: Emotions
    ): Call<PredictResponse>
}