package com.example.painthings.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.painthings.network.ApiConfig
import com.example.painthings.network.LoginBody
import com.example.painthings.network.LoginResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel : ViewModel() {
    private val loginRes = MutableLiveData<LoginResponse>()

    fun login(body: LoginBody) {

        ApiConfig.getApiService().login(body).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    loginRes.postValue(response.body())
                } else {
                    val errorObj = LoginResponse(
                        "login",
                        "login",
                        "login",
                        "login",
                    )
                    loginRes.postValue(errorObj)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("error", t.message.toString())
            }

        })
    }

    fun getMe(cookie: String) {
        ApiConfig.getApiService().getMe(cookie).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.code() != 401) {
                    loginRes.postValue(response.body())
                } else {
                    val errorObj = LoginResponse(
                        "login",
                        "login",
                        "login",
                        "login",
                    )
                    loginRes.postValue(errorObj)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("error", t.message.toString())
            }

        })
    }

    fun getLoginStatus(): LiveData<LoginResponse> {
        return loginRes
    }
}