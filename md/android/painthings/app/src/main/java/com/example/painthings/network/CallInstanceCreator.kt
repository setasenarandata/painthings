package com.example.painthings.network

import com.google.gson.InstanceCreator
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Request
import retrofit2.Call
import java.lang.reflect.Type

class CallInstanceCreator<T> : InstanceCreator<Call<T>> {
    override fun createInstance(type: Type): Call<T> {
        // Return a dummy implementation of Call
        return object : Call<T> {
            // Implement the required methods with dummy behavior
            // You can customize these methods if needed
            override fun enqueue(callback: retrofit2.Callback<T>) {}
            override fun isExecuted(): Boolean = false
            override fun clone(): Call<T> = this
            override fun isCanceled(): Boolean = false
            override fun request(): Request {
                throw NotImplementedError("The request() method is not supported in this dummy Call implementation.")
            }
            override fun cancel() {}
            override fun execute(): retrofit2.Response<T> {
                throw UnsupportedOperationException("The execute() method is not supported in this dummy Call implementation.")
            }
        }
    }
}