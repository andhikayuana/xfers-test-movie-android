package id.yuana.movieapp.xfers.core.data.repository

import id.yuana.movieapp.xfers.core.data.model.Movie
import id.yuana.movieapp.xfers.core.data.model.Resource
import id.yuana.movieapp.xfers.core.data.remote.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author andhikayuana
 */
class MovieRepositoryImpl(private val api: MovieService, private val apiKey: String) :
    MovieRepository {

    //TODO perhaps can change to response model
    override suspend fun getMovies(query: String, page: Int): Resource<List<Movie>> {
        return withContext(Dispatchers.IO) {
            Resource.loading(data = null)
            try {
                Resource.success(
                    data = api.getMovies(
                        apiKey = apiKey,
                        query = query,
                        page = page
                    ).results
                )
            } catch (e: Exception) {
                Resource.error(data = null, message = e.message ?: "Oops, something went wrong")
            }

        }
    }


}