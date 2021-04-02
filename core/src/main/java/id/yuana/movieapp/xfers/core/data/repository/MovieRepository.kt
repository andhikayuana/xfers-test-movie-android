package id.yuana.movieapp.xfers.core.data.repository

import id.yuana.movieapp.xfers.core.data.model.Movie
import id.yuana.movieapp.xfers.core.data.model.Resource

interface MovieRepository {

    suspend fun getMovies(query: String, page: Int): Resource<List<Movie>>
}