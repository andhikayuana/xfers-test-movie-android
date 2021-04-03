package id.yuana.movieapp.xfers.core

import id.yuana.movieapp.xfers.core.data.remote.MovieApi
import id.yuana.movieapp.xfers.core.data.remote.MovieService
import id.yuana.movieapp.xfers.core.data.repository.MovieRepositoryImpl

/**
 * @author andhikayuana
 */
open class MovieComponent @JvmOverloads constructor(
    private val baseUrl: String,
    private val apiKey: String
) {

    val api: MovieService by lazy { MovieApi.createService(baseUrl) }

    val repository: MovieRepositoryImpl by lazy { MovieRepositoryImpl(api, apiKey) }

}