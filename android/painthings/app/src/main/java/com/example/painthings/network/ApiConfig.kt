package com.example.painthings.network

import android.util.Log
import android.webkit.CookieManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiConfig {
    companion object{
//        private lateinit var sharedPreferences: SharedPreferences

        private var TIMEOUT_MILLIS = 20000

        fun getApiService(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://painthings-dot-proven-reality-379717.et.r.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(setupOkhttpInterceptor())
                .build()
            return retrofit.create(ApiService::class.java)
        }

        fun getMlApiService(): MlApiService {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://mlpainthings-dot-proven-reality-379717.et.r.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(MlApiService::class.java)
        }

        fun getWikiArtService(): WikiArtApiService {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val gson: Gson = GsonBuilder()
                .registerTypeAdapter(Call::class.java, CallInstanceCreator<Any>())
                .create()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.wikiart.org/en/api/2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
            return retrofit.create(WikiArtApiService::class.java)
        }
        private fun setupOkhttpInterceptor(): OkHttpClient {

            var cookieManager: CookieManager

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY


            val builder = OkHttpClient.Builder()
                .followRedirects(false)
                .cookieJar(object : CookieJar {

                    /**
                     * @param url
                     * @param cookies list of cookies get in api response
                     */
                    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                        cookieManager = CookieManager.getInstance()
                        for (cookie in cookies) {
                            cookieManager.setCookie(url.toString(), cookie.toString())
                            Log.e("ok", "saveFromResponse :  Cookie url : $url$cookie")
                        }

//                        saveCookies(cookies) // Call the saveCookies function here
                    }

                    /**
                     * @param url
                     *
                     * adding cookies with request
                     */
                    override fun loadForRequest(url: HttpUrl): List<Cookie> {
                        cookieManager = CookieManager.getInstance()

                        val cookies: ArrayList<Cookie> = ArrayList()
                        if (cookieManager.getCookie(url.toString()) != null) {
                            val splitCookies =
                                cookieManager.getCookie(url.toString()).split("[,;]".toRegex())
                                    .dropLastWhile { it.isEmpty() }.toTypedArray()
                            for (i in splitCookies.indices) {
                                cookies.add(Cookie.parse(url, splitCookies[i].trim { it <= ' ' })!!)
                                Log.e(
                                    "ok",
                                    "loadForRequest :Cookie.add ::  " + Cookie.parse(
                                        url,
                                        splitCookies[i].trim { it <= ' ' })!!
                                )
                            }
                        }
                        return cookies
                    }
                })
                .followSslRedirects(false)
                .cache(null)
                .addInterceptor { chain ->
                    val request: Request = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build()
                    chain.proceed(request)
                }
                .addInterceptor(interceptor)
                .connectTimeout(TIMEOUT_MILLIS.toLong(), TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT_MILLIS.toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT_MILLIS.toLong(), TimeUnit.MILLISECONDS)


            return builder.build()
        }
    }
}