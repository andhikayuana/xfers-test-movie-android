package id.yuana.movieapp.xfers.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import id.yuana.movieapp.xfers.R
import id.yuana.movieapp.xfers.core.data.model.Status
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupObserver()

        viewModel.fetchMovies()

    }

    private fun setupUI() {
        homeAdapter = HomeAdapter {
            //todo
            Log.d("YUANA", it.toString())
        }
        swipeRefresh.setColorSchemeColors(
            ResourcesCompat.getColor(
                resources,
                R.color.design_default_color_primary,
                null
            )
        )
        swipeRefresh.setOnRefreshListener {
            homeAdapter.clear()
            viewModel.fetchMovies()
        }
        rvHomeMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
        }
    }

    private fun setupObserver() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { movies ->
                        homeAdapter.addOrUpdate(movies)
                    }
                    swipeRefresh.isRefreshing = false
                }
                Status.ERROR -> {
                    Snackbar.make(coordinatorHome, it.message.toString(), Snackbar.LENGTH_SHORT)
                        .show()
                    swipeRefresh.isRefreshing = false
                }
                Status.LOADING -> {
                    swipeRefresh.isRefreshing = true
                }
            }
        })
    }
}