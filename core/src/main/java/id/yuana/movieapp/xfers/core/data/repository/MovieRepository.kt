package id.yuana.movieapp.xfers.core.data.repository

import id.yuana.movieapp.xfers.core.data.model.GetMoviesResponse
import id.yuana.movieapp.xfers.core.data.model.Resource

/**
 * @author andhikayuana
 */
interface MovieRepository {

    suspend fun getMovies(query: String, page: Int): Resource<GetMoviesResponse>
}