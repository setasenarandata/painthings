package com.example.painthings.network

import com.example.painthings.emotions.Emotions
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

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
    ): CreatePostResponse

    // post by id
    @GET("posts/{id}")
    suspend fun getPostById(
        @Path("id") id: String,
    ): EmotionResponseItem

    // format date: dd-mm-yyyy
    @GET("posts/date/{createdAt}")
    suspend fun getPostByDate(
        @Path("createdAt") createdAt: String,
    ): EmotionResponseItem
}