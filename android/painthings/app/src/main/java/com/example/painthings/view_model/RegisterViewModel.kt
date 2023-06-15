package com.example.painthings.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.painthings.network.ApiConfig
import com.example.painthings.network.RegisterBody
import com.example.painthings.network.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterViewModel : ViewModel() {
    private val registerRes = MutableLiveData<RegisterResponse>()

    fun register(body: RegisterBody) {
        ApiConfig.getApiService().register(body).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    registerRes.postValue(response.body())
                } else {
                    Log.d("TAG", "ERROR WAS FOUND")
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("error", t.message.toString())
            }

        })
    }

    fun getStatus(): LiveData<RegisterResponse> {
        return registerRes
    }
}