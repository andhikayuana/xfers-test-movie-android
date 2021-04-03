package id.yuana.movieapp.xfers.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import id.yuana.movieapp.xfers.R
import id.yuana.movieapp.xfers.core.data.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * @author andhikayuana
 */
class HomeAdapter(private val onClickItemMovie: (movie: Movie) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val data: MutableList<Movie> = mutableListOf()

    fun addOrUpdate(data: List<Movie>) {
        this.data.addAll(data.toMutableList())
        notifyDataSetChanged()
    }

    fun clear() {
        this.data.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.item_movie, parent, false)
        return HomeViewHolder(view, onClickItemMovie)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    class HomeViewHolder(itemView: View, private val onClickItemMovie: (movie: Movie) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie) {
            itemView.apply {
                tvTitle.text = movie.title
                tvReleaseOn.text =
                    resources.getString(R.string.label_release_on, movie.getReleaseOn())
                tvOverview.text = movie.overview
                ivPoster.apply {
                    transitionName = movie.getPosterUrl()
                }
                ivPoster.load(movie.getPosterUrl()) {
                    crossfade(true)
                    placeholder(R.drawable.bg_splash)
                }
                cardItemMovie.setOnClickListener {
                    onClickItemMovie(movie)
                }
            }
        }

    }

}
