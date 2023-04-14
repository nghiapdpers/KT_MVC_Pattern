package nghiapd.pers.kt_mvc_pattern

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object APIHelper {
    private var retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    val apiService: APIService = retrofit.create(APIService::class.java)
}