package id.yuana.movieapp.xfers.core.data.remote

import id.yuana.movieapp.xfers.core.data.model.GetMoviesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieService {

    @GET("/3/search/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String? = null,
        @Query("page") page: Int = 1,
    ): GetMoviesResponse
}

object MovieApi {

    fun createService(baseUrl: String): MovieService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }

}