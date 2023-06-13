package com.example.painthings.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "emotion")
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

    @field:SerializedName("journal")
    val journal: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = "",

    @field:SerializedName("user")
    val user: UserPainthings,
)

data class WikiArtDetailResponse(
    @PrimaryKey
    @field:SerializedName("id")
    val id: String? = "",

    @field:SerializedName("title")
    val title: String? = "",

    @field:SerializedName("completitionYear")
    val completitionYear: Int? = 0,

    @field:SerializedName("artistName")
    val artistName: String? = "",

    @field:SerializedName("image")
    val image: String? = "",

    @field:SerializedName("description")
    val description: String? = "",
)

data class ArtResponse(
    val id: String,
    val Style: String,
    val Category: String,
    val Artist: String,
    val Title: String
)

data class UserPainthings(
    val name: String,
    val email: String
)

data class PredictResponse(
    @field:SerializedName("hasil clusteting")
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