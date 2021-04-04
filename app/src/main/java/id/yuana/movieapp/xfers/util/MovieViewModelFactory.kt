package id.yuana.movieapp.xfers.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieViewModelFactory {

    companion object {
        fun create(
            create: () -> ViewModel
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")// Casting T as ViewModel
                    return create.invoke() as T
                }
            }
        }
    }

}