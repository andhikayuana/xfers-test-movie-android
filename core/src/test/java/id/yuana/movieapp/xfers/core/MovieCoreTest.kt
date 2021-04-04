package id.yuana.movieapp.xfers.core

import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieCoreTest {

    companion object {
        const val FAKE_BASE_URL = ""
        const val FAKE_API_KEY = ""
    }

    @Test(expected = RuntimeException::class)
    fun `test given not init MovieCore then should error`() {
        MovieCore.instance
    }

    @Test
    fun `test given valid component then should success`() {

        MovieCore.init(FAKE_BASE_URL, FAKE_API_KEY)

        assertNotNull(MovieCore.instance)

        MovieCore.instance.destroy()
    }
}