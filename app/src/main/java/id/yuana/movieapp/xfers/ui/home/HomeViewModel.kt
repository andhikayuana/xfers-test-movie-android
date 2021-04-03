package id.yuana.movieapp.xfers.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.yuana.movieapp.xfers.core.MovieCore
import id.yuana.movieapp.xfers.core.data.model.GetMoviesResponse
import id.yuana.movieapp.xfers.core.data.model.Movie
import id.yuana.movieapp.xfers.core.data.model.Resource
import id.yuana.movieapp.xfers.core.data.repository.MovieRepositoryImpl
import kotlinx.coroutines.launch

/**
 * @author andhikayuana
 */
class HomeViewModel : ViewModel() {

    companion object {
        const val DEFAULT_QUERY: String = "superman"
        const val DEFAULT_PAGE: Int = 1
    }

    private val repository: MovieRepositoryImpl = MovieCore.instance.component.repository

    val fetchMovies: MutableLiveData<Resource<GetMoviesResponse>> by lazy {
        MutableLiveData<Resource<GetMoviesResponse>>(Resource.loading(data = null))
    }

    val movies: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>(mutableListOf())
    }

    val currentPage: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(DEFAULT_PAGE)
    }
    val totalPage: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(DEFAULT_PAGE)
    }

    init {

    }

    fun fetchMovies() {
        viewModelScope.launch {
            currentPage.value?.let {
                fetchMovies.value =
                    repository.getMovies(query = DEFAULT_QUERY, page = it)
            }
        }
    }

    fun resetState() {
        currentPage.value = DEFAULT_PAGE
    }
}