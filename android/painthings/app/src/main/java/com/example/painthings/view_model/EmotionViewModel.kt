package com.example.painthings.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.painthings.emotions.Emotions
import com.example.painthings.network.ApiConfig
import com.example.painthings.network.EmotionResponseItem
import com.example.painthings.network.PredictResponse
import com.example.painthings.network.UserPainthings
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmotionViewModel(): ViewModel() {
    private val resCluster = MutableLiveData<PredictResponse>()

    fun getCluster(emotions: Emotions) {

        ApiConfig.getMlApiService().predictCluster(emotions).enqueue(object : Callback<PredictResponse> {
            override fun onResponse(call: Call<PredictResponse>, response: Response<PredictResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    resCluster.postValue(response.body())
                } else {
                    val errorObj = PredictResponse(
                        "INVALID"
                    )
                    resCluster.postValue(errorObj)
                }
            }

            override fun onFailure(call: Call<PredictResponse>, t: Throwable) {
                Log.d("error", t.message.toString())
            }
        })
    }

    fun getResCluster(): LiveData<PredictResponse> {
        return resCluster
    }
}