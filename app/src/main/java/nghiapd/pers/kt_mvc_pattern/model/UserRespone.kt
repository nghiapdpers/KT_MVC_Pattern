package nghiapd.pers.kt_mvc_pattern.model

import com.squareup.moshi.Json

data class UserRespone(@Json(name = "results") val results: List<User>);