package id.yuana.movieapp.xfers.core.data.repository

import id.yuana.movieapp.xfers.core.data.model.GetMoviesResponse
import id.yuana.movieapp.xfers.core.data.remote.MovieService
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryImplTest : TestCase() {

    private lateinit var movieRepository: MovieRepositoryImpl

    private val mockApi: MovieService = Mockito.mock(MovieService::class.java)

    companion object {
        const val FAKE_API_KEY = "loremipsum"
    }

    @Before
    public override fun setUp() {
        super.setUp()

        movieRepository = MovieRepositoryImpl(mockApi, FAKE_API_KEY)
    }

    @Test
    fun testGivenValidApiKeyThenShouldSuccess() {
        runBlocking {

            val response = GetMoviesResponse(1, listOf(), 1, 1)

            given(mockApi.getMovies(FAKE_API_KEY, "", 1)).willReturn(response)

            movieRepository.getMovies("", 1)

            verify(mockApi).getMovies(FAKE_API_KEY, "", 1)
        }
    }

    @Test
    @Throws(Exception::class)
    fun testGivenInvalidApiKeyThenShouldError() {
        runBlocking {
            val response = GetMoviesResponse(1, listOf(), 1, 1)

            given(mockApi.getMovies(FAKE_API_KEY, "", 1)).willThrow(RuntimeException())

            movieRepository.getMovies("", 1)

            verify(mockApi).getMovies(FAKE_API_KEY, "", 1)
        }
    }


}