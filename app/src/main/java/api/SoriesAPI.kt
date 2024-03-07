package api

interface SoriesAPI {
    //Register
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("register") //register here
    fun createUser(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("gender") gender:Int,
        @Field("age_range") ageRange:Int,
        @Field("password") password:String
    ): Call<DefaultResponse>
}