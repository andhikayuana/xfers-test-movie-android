package id.yuana.movieapp.xfers.core.data.repository

import id.yuana.movieapp.xfers.core.data.model.GetMoviesResponse
import id.yuana.movieapp.xfers.core.data.model.Resource
import id.yuana.movieapp.xfers.core.data.remote.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author andhikayuana
 */
class MovieRepositoryImpl(private val api: MovieService, private val apiKey: String) :
    MovieRepository {

    override suspend fun getMovies(query: String, page: Int): Resource<GetMoviesResponse> {
        return withContext(Dispatchers.IO) {
            Resource.loading(data = null)
            try {
                val response = api.getMovies(
                    apiKey = apiKey,
                    query = query,
                    page = page
                )
                Resource.success(
                    data = response
                )
            } catch (e: Exception) {
                Resource.error(data = null, message = e.message ?: "Oops, something went wrong")
            }

        }
    }


}