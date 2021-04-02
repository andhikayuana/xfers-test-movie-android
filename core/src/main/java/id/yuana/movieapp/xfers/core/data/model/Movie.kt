package id.yuana.movieapp.xfers.core.data.model

import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat

data class Movie(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("genre_ids") val genre_ids: List<Int>,
    @SerializedName("id") val id: Int,
    @SerializedName("original_language") val original_language: String,
    @SerializedName("original_title") val original_title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("vote_count") val vote_count: Int
) {

    fun getPosterUrl(width: String = "w185"): String =
        "http://image.tmdb.org/t/p/${width}${poster_path}"

    //    2015-01-19
    @SuppressLint("SimpleDateFormat")
    fun getReleaseOn(): String {
        val date = SimpleDateFormat("yyyy-MM-dd").parse(release_date)
        return SimpleDateFormat("MMM dd, yyyy").format(date)
    }
}