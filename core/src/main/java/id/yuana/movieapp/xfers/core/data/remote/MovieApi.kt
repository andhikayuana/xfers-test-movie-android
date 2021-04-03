package id.yuana.movieapp.xfers.core.data.remote

import id.yuana.movieapp.xfers.core.BuildConfig
import id.yuana.movieapp.xfers.core.data.model.GetMoviesResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author andhikayuana
 */
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
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }

    private fun createHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor())
            .build()

    }

    private fun createLoggingInterceptor(): Interceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        return httpLoggingInterceptor

    }

}