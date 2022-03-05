package com.example.flixster

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.json.JSONArray
@Parcelize
data class Movie (
    val movieId: Int,
    val voteAverage: Double,
    private val posterPath: String,
    val title: String,
    val overview: String,
) : Parcelable {
    @IgnoredOnParcel
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object{
        fun fromJasonArray(movieJasonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for(i in 0 until movieJasonArray.length() ){
                val movieJason = movieJasonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJason.getInt("id"),
                        movieJason.getDouble("vote_average"),
                        movieJason.getString("poster_path"),
                        movieJason.getString("title"),
                        movieJason.getString("overview")
                    )
                )
            }
            return movies
        }

    }

}