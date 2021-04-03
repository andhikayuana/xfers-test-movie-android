package id.yuana.movieapp.xfers

import android.app.Application
import id.yuana.movieapp.xfers.core.MovieCore

/**
 * @author andhikayuana
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        MovieCore.init(
            baseUrl = BuildConfig.MOVIE_BASE_URL,
            apiKey = BuildConfig.MOVIE_API_KEY,
        )
    }
}