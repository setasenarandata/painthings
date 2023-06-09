package com.example.painthings.network

import com.example.painthings.emotions.Emotions
import retrofit2.Call
import retrofit2.http.*

class RegisterBody(val name: String, val email: String, val password: String, val birthdate: String)
class LoginBody(val email: String, val password: String)

interface ApiService {
    @POST("login")
    fun login(
        @Body loginBody: LoginBody
    ): Call<LoginResponse>


    @POST("users")
    fun register(
        @Body registerBody: RegisterBody
    ): Call<RegisterResponse>

    // pake cookie
    @GET("posts")
    suspend fun getPost(): List<EmotionResponseItem>

    // create new post
    @POST("posts")
    suspend fun createPost(
        @Body emotions: Emotions
    ): Call<CreatePostResponse>

    // post by id
    @GET("posts/{id}")
    suspend fun getPostById(
        @Path("id") id: String,
    ): EmotionResponseItem

    // format date: dd-mm-yyyy
    @GET("posts/date/{createdAt}")
    fun getPostByDate(
        @Path("createdAt") createdAt: String,
    ): Call<EmotionResponseItem>

    @GET("me")
    fun getMe(
        @Header("Cookie") cookie: String,
    ): Call<LoginResponse>
}