package id.yuana.movieapp.xfers.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.yuana.movieapp.xfers.core.MovieCore
import id.yuana.movieapp.xfers.core.data.repository.MovieRepositoryImpl
import id.yuana.movieapp.xfers.util.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    companion object {
        const val FAKE_BASE_URL = "http://api.themoviedb.org"
        const val FAKE_API_KEY = ""
    }

    @get:Rule
    val testCoroutineRule = CoroutinesTestRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MovieCore.init(FAKE_BASE_URL, FAKE_API_KEY)
    }

    @After
    fun tearDown() {
        MovieCore.instance.destroy()
    }

    @Test
    fun `test fetch movies then should success`() {

        val mockRepository = mock(MovieRepositoryImpl::class.java)
        val viewModel = HomeViewModel(mockRepository)

        testCoroutineRule.runBlockingTest {

            viewModel.fetchMovies()

            verify(mockRepository).getMovies("superman", 1)
        }


    }
}