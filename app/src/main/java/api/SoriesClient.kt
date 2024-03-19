package api

import android.content.SharedPreferences
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import okhttp3.HttpUrl
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import java.util.concurrent.TimeUnit
import java.util.HashMap

object SoriesClient {
    private lateinit var sharedPreferences: SharedPreferences
    private const val BASE_URL = "https://bytemeifyoucan-ecomm.soriesthriftshop.online/"

    val instance: SoriesAPI by lazy { createInstance() }

    fun setSharedPreferences(kek: SharedPreferences) {
        sharedPreferences = kek
    }

    private fun createInstance(): SoriesAPI {
        val cookieJar = object : CookieJar {
            private val cookieStore = HashMap<HttpUrl, List<Cookie>>()

            override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                cookieStore[url] = cookies
            }

            override fun loadForRequest(url: HttpUrl): List<Cookie> {
                return cookieStore[url] ?: emptyList()
            }
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .cookieJar(cookieJar) // Don't forget to set the cookieJar to the OkHttpClient
            .build()

        // Create a custom Gson instance that is lenient
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            // Use the custom Gson instance with GsonConverterFactory
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
        return retrofit.create(SoriesAPI::class.java)
    }
}
