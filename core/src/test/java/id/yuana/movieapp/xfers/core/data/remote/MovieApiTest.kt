package id.yuana.movieapp.xfers.core.data.remote

import id.yuana.movieapp.xfers.core.util.MockResponseFileReader
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.net.HttpURLConnection

@RunWith(MockitoJUnitRunner::class)
class MovieApiTest {

    companion object {
        const val RESPONSE_SUCCESS = "get_movies_response_success.json"
        const val RESPONSE_ERROR = "get_movies_response_error.json"
    }

    private lateinit var api: MovieService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {

        mockWebServer = MockWebServer()
        mockWebServer.start(9090)

        api = MovieApi.createService("http://localhost:9090")
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `read sample get_movies_response_success`() {
        val reader = MockResponseFileReader(RESPONSE_SUCCESS)
        assertNotNull(reader.content)
    }

    @Test
    fun `fetch movies with valid apiKey then should success`() {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockResponseFileReader(RESPONSE_SUCCESS).content)

        mockWebServer.enqueue(response)

        val actualResponse = runBlocking {
            api.getMovies("validapikey", "superman", 1)
        }

        assertNotNull(actualResponse)
    }

    @Test(expected = RuntimeException::class)
    fun `fetch movies with invalid apiKey then should success`() {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
            .setBody(MockResponseFileReader(RESPONSE_ERROR).content)

        mockWebServer.enqueue(response)

        val actualResponse = runBlocking {
            api.getMovies("invalidapikey", "superman", 1)
        }
    }


}