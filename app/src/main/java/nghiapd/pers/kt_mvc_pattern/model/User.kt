package nghiapd.pers.kt_mvc_pattern.model

import com.squareup.moshi.Json

data class User(@Json(name = "name") val name: Name,
                @Json(name = "email") val email:String,
                @Json(name = "phone") val phone:String,
                @field:Json(name = "picture") val imgSrc: Picture){
    data class Name(val title:String, val first:String, val last:String);
    data class Picture(val large:String, val medium:String, val thumbnail:String);
}