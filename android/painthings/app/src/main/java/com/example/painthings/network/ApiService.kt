package com.example.painthings.network

import com.example.painthings.emotions.Emotions
import retrofit2.Call
import retrofit2.http.*

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
    fun createPost(
        @Body emotions: PostBody
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

    @GET("art/{id}")
    fun fetchCluster(
        @Path("id") id: Int,
    ): Call<List<ArtResponse>>
}

data class RegisterBody(val name: String, val email: String, val password: String, val birthdate: String)

data class LoginBody(val email: String, val password: String)

data class PostBody(
    val love: Int,
    val sad: Int,
    val anger: Int,
    val happiness: Int,
    val disgust: Int,
    val optimism: Int,
    val art_id: String,
    val journal: String
)