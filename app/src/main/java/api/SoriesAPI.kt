package api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

data class LoginResponse(val token: String)

data class UserProfileResponse(val username: String, val email: String)

interface SoriesAPI {
    // Register
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("register")
    fun registerUser(
        @Field("name") name: String,
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<DefaultResponse>

    // Login
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("login")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    // User Profile
    @Headers("Accept: application/json")
    @POST("userProfile")
    fun getUserProfile(): Call<UserProfileResponse>

    // Logout
    @Headers("Accept: application/json")
    @POST("logout")
    fun logoutUser(): Call<DefaultResponse>
}