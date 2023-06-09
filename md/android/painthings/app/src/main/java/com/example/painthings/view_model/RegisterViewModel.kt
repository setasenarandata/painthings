package com.example.painthings.view_model

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.painthings.network.ApiConfig
import com.example.painthings.network.RegisterBody
import com.example.painthings.network.RegisterResponse
import io.github.muddz.styleabletoast.StyleableToast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterViewModel : ViewModel() {
    private val registerRes = MutableLiveData<RegisterResponse>()

    fun register(body: RegisterBody) {
        ApiConfig.getApiService().register(body).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    Log.d("TAG", response.body()?.msg.toString())
                    if (response.code() == 201) {
                        registerRes.postValue(response.body())
                    }
                } else {
                    val errorMsg = JSONObject(response.errorBody()!!.string()).getString("msg")
                    if (errorMsg == "Email sudah digunakan") {
                        val errorObj = RegisterResponse(
                            "This email is taken"
                        )
                        registerRes.postValue(errorObj)
                    } else {
                        val errorObj = RegisterResponse(
                            "INVALID"
                        )
                        registerRes.postValue(errorObj)
                    }
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