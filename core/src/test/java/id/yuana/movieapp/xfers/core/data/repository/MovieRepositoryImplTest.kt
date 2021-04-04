package id.yuana.movieapp.xfers.core.data.repository

import id.yuana.movieapp.xfers.core.data.model.GetMoviesResponse
import id.yuana.movieapp.xfers.core.data.remote.MovieService
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

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
    fun `test given valid apiKey then should success`() {
        runBlocking {

            val response = GetMoviesResponse(1, listOf(), 1, 1)

            given(mockApi.getMovies(FAKE_API_KEY, "", 1)).willReturn(response)

            movieRepository.getMovies("", 1)

            verify(mockApi).getMovies(FAKE_API_KEY, "", 1)
        }
    }

    @Test
    @Throws(Exception::class)
        fun `test given invalid ApiKey then should error`() {
        runBlocking {
            val response = GetMoviesResponse(1, listOf(), 1, 1)

            given(mockApi.getMovies(FAKE_API_KEY, "", 1)).willThrow(RuntimeException())

            movieRepository.getMovies("", 1)

            verify(mockApi).getMovies(FAKE_API_KEY, "", 1)
        }
    }


}