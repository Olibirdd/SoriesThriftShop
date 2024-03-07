package api

import android.content.SharedPreferences
import android.webkit.CookieSyncManager.createInstance
import java.util.concurrent.TimeUnit

object SoriesClient {
    private lateinit var sharedPreferences: SharedPreferences
    val instance: SoriesAPI by lazy { createInstance() }

    fun setSharedPreferences(kek:SharedPreferences){
        sharedPreferences = kek
    }
    private fun createInstance(): SoriesAPI{
        val okHttpClient = OkHttpClient.Builder()
            .addInterception{chain ->
                val request = chain.request().newBuilder()
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseURL(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(SoriesAPI::class.java)
    }
   private const val BASE_URL = "https://"
}