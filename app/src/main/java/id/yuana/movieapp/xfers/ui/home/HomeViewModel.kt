package id.yuana.movieapp.xfers.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.yuana.movieapp.xfers.core.MovieCore
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

    val movies: MutableLiveData<Resource<List<Movie>>> by lazy {
        MutableLiveData<Resource<List<Movie>>>(Resource.loading(data = null))
    }

    val query: MutableLiveData<String> by lazy {
        MutableLiveData<String>(DEFAULT_QUERY)
    }

    val currentPage: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(DEFAULT_PAGE)
    }

    init {

    }

    fun fetchMovies() {
        viewModelScope.launch {
            movies.value = repository.getMovies(query = query.value!!, page = currentPage.value!!)
        }

    }
}