package id.yuana.movieapp.xfers.core.data.repository

import id.yuana.movieapp.xfers.core.data.model.Movie

interface MovieRepository {

    suspend fun getMovies(query: String, page: Int): List<Movie>
}