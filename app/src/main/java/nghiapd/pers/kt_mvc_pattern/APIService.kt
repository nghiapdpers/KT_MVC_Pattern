package nghiapd.pers.kt_mvc_pattern

import nghiapd.pers.kt_mvc_pattern.model.UserRespone
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/api/")
    fun getUser(@Query("results") num : Int): Call<UserRespone>
}