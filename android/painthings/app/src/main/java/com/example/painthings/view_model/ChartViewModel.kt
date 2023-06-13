package com.example.painthings.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.painthings.network.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChartViewModel(): ViewModel() {
    private val chartRes = MutableLiveData<EmotionResponseItem>()
    private val wikiArt = MutableLiveData<WikiArtDetailResponse>()

    fun getChart(date: String) {

        ApiConfig.getApiService().getPostByDate(date).enqueue(object : Callback<EmotionResponseItem> {
            override fun onResponse(call: Call<EmotionResponseItem>, response: Response<EmotionResponseItem>) {
                if (response.isSuccessful && response.body() != null) {
                    chartRes.postValue(response.body())
                } else {
                    val errorObj = EmotionResponseItem(
                        0, "", 0, 0, 0, 0, 0, 0, "", "", "", UserPainthings("", "")
                    )
                    chartRes.postValue(errorObj)
                }
            }

            override fun onFailure(call: Call<EmotionResponseItem>, t: Throwable) {
                Log.d("error", t.message.toString())
            }
        })
    }

    suspend fun getArtDetails(artId: String) {
        try {
            val response = ApiConfig.getWikiArtService().getPaintingDetails(artId)
            if (response.id == artId) {
                wikiArt.postValue(response)
            } else {
                Log.e("WIKIERROR", "ERROR FOUND")
            }
        } catch (e: Exception) {
            Log.e("WIKIERROR", "Error occurred during API requests CATCH 1: ${e.message}")
        }
    }

    fun getChartStatus(): LiveData<EmotionResponseItem> {
        return chartRes
    }

    fun getArtStatus(): LiveData<WikiArtDetailResponse> {
        return wikiArt
    }
}