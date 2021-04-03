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

/**
Hi Andhika,

Thank you again for applying for the Android Engineer Position!

As a part of our selection process, our team has designed a simple assignment to assess your android development skills.

We hope to receive your assignment on Monday (5th of April) latest by 9am WIB.

Note: The app should be build using Flutter/Kotlin and dart language

Evaluation Criteria:
·Class and method names should clearly show their intent and responsibility
·Widgets should not know about business logic and non UI classes
·Your solution should easily accommodate possible future requirement changes
·Implement Unit Test cases. (For bonus points)
·Choose better architecture (BLoC recommended).

Requirements:
1. Fetch List of movies from this URL
http://api.themoviedb.org/3/search/movie?api_key=6753d9119b9627493ae129f3c3c99151&query=superman&page=1

2. Poster (size: w92, w185,w500)
http://image.tmdb.org/t/p/w92/2DtPSyODKWXluIRV7PVru0SSzja.jpg

3. Display result in ListView or GridView. The list would have following rows Movie Image, Movie Name, Release date, Full description/Overview

4. Tapping on cell should display the detail screen.

5. Pagination: when the user reaches to the bottom of the list, it should load the second page if available.

If you have any further questions, please let me know.

Thank you and good luck!

--
Best Regards,
Nadira Sarah
Talent Acquisition
 **/