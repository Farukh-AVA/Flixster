package com.example.flixster

import org.json.JSONArray

data class Movie (
    val movieId: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object{
        fun fromJasonArray(movieJasonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for(i in 0 until movieJasonArray.length() ){
                val movieJason = movieJasonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJason.getInt("id"),
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