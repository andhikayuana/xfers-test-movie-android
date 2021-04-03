package id.yuana.movieapp.xfers.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import coil.load
import coil.transform.BlurTransformation
import id.yuana.movieapp.xfers.R
import id.yuana.movieapp.xfers.core.data.model.Movie
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * @author andhikayuana
 */
class DetailFragment : Fragment(R.layout.fragment_detail) {

    companion object {
        private const val ARG_MOVIE_ITEM: String = "ARG_MOVIE_ITEM"

        fun createBundle(movie: Movie): Bundle {
            return bundleOf(ARG_MOVIE_ITEM to movie)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(requireContext())
                .inflateTransition(R.transition.shared_element_transition)
        sharedElementReturnTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_element_transition)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie: Movie = arguments?.getSerializable(ARG_MOVIE_ITEM) as Movie

        setupUI(movie)
    }

    private fun setupUI(movie: Movie) {
        tvTitle.text = movie.title
        tvReleaseOn.text = getString(R.string.label_release_on, movie.getReleaseOn())
        tvOverview.text = movie.overview
        ivPoster.apply {
            transitionName = movie.getPosterUrl()
        }
        ivPoster.load(movie.getPosterUrl()) {
            crossfade(true)
            placeholder(R.drawable.bg_splash)
        }
        ivPosterBlur.load(movie.getPosterUrl()) {
            crossfade(true)
            placeholder(R.drawable.bg_splash)
            transformations(BlurTransformation(requireContext()))
        }
        ivBackdrop.load(movie.getBackdropUrl()) {
            crossfade(true)
            placeholder(R.drawable.bg_splash)
        }
        tvRating.text = getString(R.string.label_rating, movie.vote_average.toString())
    }
}