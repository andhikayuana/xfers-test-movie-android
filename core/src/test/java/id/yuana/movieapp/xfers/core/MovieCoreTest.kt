package id.yuana.movieapp.xfers.core

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieCoreTest : TestCase() {

    companion object {
        const val FAKE_BASE_URL = ""
        const val FAKE_API_KEY = ""
    }

    @Before
    public override fun setUp() {
        super.setUp()
    }

    @Test(expected = RuntimeException::class)
    fun testGivenNotInitMovieCoreThenShouldError() {
        MovieCore.instance
    }

    @Test
    fun testGivenValidComponentThenShouldSuccess() {

        MovieCore.init(FAKE_BASE_URL, FAKE_API_KEY)

        assertNotNull(MovieCore.instance)

        MovieCore.instance.destroy()
    }
}