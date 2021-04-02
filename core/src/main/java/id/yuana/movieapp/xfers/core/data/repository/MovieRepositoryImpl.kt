package id.yuana.movieapp.xfers.core.data.repository

import id.yuana.movieapp.xfers.core.data.model.Movie
import id.yuana.movieapp.xfers.core.data.remote.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(private val api: MovieService, private val apiKey: String) :
    MovieRepository {

    override suspend fun getMovies(query: String, page: Int): List<Movie> {
        return withContext(Dispatchers.IO) {
            api.getMovies(apiKey = apiKey, query = query, page = page).results
        }
    }


}