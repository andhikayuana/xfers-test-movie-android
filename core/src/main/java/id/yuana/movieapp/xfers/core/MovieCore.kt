package id.yuana.movieapp.xfers.core

/**
 * @author andhikayuana
 */
class MovieCore private constructor(val component: MovieComponent) {

    companion object {

        @Volatile
        private var INSTANCE: MovieCore? = null

        @JvmStatic
        fun init(baseUrl: String, apiKey: String) {
            INSTANCE = MovieCore(
                MovieComponent(
                    baseUrl = baseUrl,
                    apiKey = apiKey,
                )
            )
        }

        val instance: MovieCore
            get() {
                if (INSTANCE == null) {
                    synchronized(MovieCore::class.java) {
                        if (INSTANCE == null) {
                            throw RuntimeException("Please init MovieCore first!")
                        }
                    }
                }

                return INSTANCE!!
            }

    }


}