package com.example.painthings.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "quote")
data class EmotionResponseItem(

    @PrimaryKey
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("uuid")
    val uuid: String,

    @field:SerializedName("love")
    val love: Int,

    @field:SerializedName("sadness")
    val sadness: Int,

    @field:SerializedName("anger")
    val anger: Int,

    @field:SerializedName("happiness")
    val happiness: Int,

    @field:SerializedName("disgust")
    val disgust: Int,

    @field:SerializedName("optimism")
    val optimism: Int,

    @field:SerializedName("art_id")
    val art_id: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = "",

    @field:SerializedName("user")
    val user: UserPainthings,


)

data class UserPainthings(
    val name: String,
    val email: String
)

data class PredictResponse(
    @field:SerializedName("hasil clustering")
    val cluster: String,
)

// Kalau berhasil 'Register Berhasil'
data class RegisterResponse(
    val msg: String,
)

data class LoginResponse(
    val uuid: String,
    val name: String,
    val email: String,
    val finalsession: String
)

data class CreatePostResponse(
    val msg: String
)