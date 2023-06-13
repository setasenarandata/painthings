package com.example.painthings.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.painthings.emotions.Emotions
import com.example.painthings.network.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmotionViewModel : ViewModel() {
    private val resCluster = MutableLiveData<PredictResponse>()
    private val clusterContainer = MutableLiveData<List<ArtResponse>>()
    private val finalArt = MutableLiveData<ArrayList<WikiArtDetailResponse>>()
    private val postRes = MutableLiveData<CreatePostResponse>()


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

    fun fetchCluster(cluter: Int) {
        ApiConfig.getApiService().fetchCluster(cluter).enqueue(object : Callback<List<ArtResponse>> {
            override fun onResponse(call: Call<List<ArtResponse>>, response: Response<List<ArtResponse>>) {
                if (response.isSuccessful && response.body() != null) {
                    clusterContainer.postValue(response.body())
                } else {
                    val errorObj = emptyList<ArtResponse>()
                    clusterContainer.postValue(errorObj)
                }
            }

            override fun onFailure(call: Call<List<ArtResponse>>, t: Throwable) {
                Log.d("error", t.message.toString())
            }
        })
    }

    suspend fun callWikiArt(it: List<ArtResponse>) {
        val list = ArrayList<WikiArtDetailResponse>()
        val deferredList = mutableListOf<Deferred<Unit>>()

        it.forEach { artResponse ->
            val deferred = CoroutineScope(Dispatchers.IO).async<Unit> {
                try {
                    val response = ApiConfig.getWikiArtService().getPaintingDetails(artResponse.id)
                    if (response.id == artResponse.id) {
                        list.add(response)
                    } else {
                        Log.e("WIKIERROR", "ERROR FOUND")
                    }
                } catch (e: Exception) {
                    Log.e("WIKIERROR", "Error occurred during API requests CATCH 1: ${e.message}")
                }
            }

            deferredList.add(deferred)
        }

        // Await all requests to complete
        try {
            coroutineScope {
                deferredList.awaitAll()
            }
        } catch (e: Exception) {
            Log.e("WIKIERROR", "Error occurred during API requests CATCH 2: ${e.message}")
        }

        Log.d("ITERATION", "DONE. POSTING TO LIVE DATA")
        finalArt.postValue(list)
    }

    fun getResCluster(): LiveData<PredictResponse> {
        return resCluster
    }

    fun getClusterContainer(): LiveData<List<ArtResponse>> {
        return clusterContainer
    }

    fun getWikiArtList(): LiveData<ArrayList<WikiArtDetailResponse>> {
        return finalArt
    }

    fun postJournal(data: PostBody) {
        ApiConfig.getApiService().createPost(data).enqueue(object : Callback<CreatePostResponse> {
            override fun onResponse(call: Call<CreatePostResponse>, response: Response<CreatePostResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    postRes.postValue(response.body())
                } else {
                    val errorObj = CreatePostResponse("Failed")
                    postRes.postValue(errorObj)
                }
            }

            override fun onFailure(call: Call<CreatePostResponse>, t: Throwable) {
                Log.d("error", t.message.toString())
            }
        })
    }

    fun getPostStatus(): LiveData<CreatePostResponse> {
        return postRes
    }
}