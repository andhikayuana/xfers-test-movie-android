package id.yuana.movieapp.xfers.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import id.yuana.movieapp.xfers.R
import id.yuana.movieapp.xfers.core.data.model.Status
import id.yuana.movieapp.xfers.listener.EndlessScrollListener
import id.yuana.movieapp.xfers.ui.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_movie.*

/**
 * @author andhikayuana
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var scrollListener: EndlessScrollListener
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupObserver()

        viewModel.fetchMovies()

    }

    private fun setupUI() {
        homeAdapter = HomeAdapter {
            val extras = FragmentNavigatorExtras(ivPoster to it.getPosterUrl())

            findNavController().navigate(
                R.id.action_homeFragment_to_detailFragment,
                DetailFragment.createBundle(it),
                null,
                extras
            )
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
            viewModel.resetState()
            viewModel.fetchMovies()
        }
        rvHomeMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeAdapter
        }
        scrollListener = object :
            EndlessScrollListener(rvHomeMovies.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(nextPage: Int): Boolean {
                viewModel.totalPage.value?.let { totalPage ->
                    if (nextPage <= totalPage) {
                        viewModel.currentPage.value = nextPage
                        viewModel.fetchMovies()
                        swipeRefresh.isRefreshing = true
                    }
                }
                return true
            }
        }
        rvHomeMovies.addOnScrollListener(scrollListener)
    }

    private fun setupObserver() {
        viewModel.fetchMovies.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { response ->
                        viewModel.movies.value?.let {
                            viewModel.movies.postValue((it + response.results).distinctBy { it.id })
                        }
                        viewModel.totalPage.value = response.total_pages
                    }
                    swipeRefresh.isRefreshing = false
                }
                Status.ERROR -> {
                    Snackbar.make(coordinatorHome, it.message.toString(), Snackbar.LENGTH_SHORT)
                        .show()
                    swipeRefresh.isRefreshing = false
                    viewModel.resetState()
                    viewModel.currentPage.value?.let {
                        scrollListener.currentPage = it - 1
                    }
                }
                Status.LOADING -> {
                    swipeRefresh.isRefreshing = true
                }
            }
        })
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            homeAdapter.addOrUpdate(it)
        })
    }
}