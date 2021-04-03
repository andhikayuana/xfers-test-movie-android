package id.yuana.movieapp.xfers.listener

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


abstract class EndlessScrollListener(private val linearLayoutManager: LinearLayoutManager) :
    RecyclerView.OnScrollListener() {

    private var loading: Boolean = false
    private var previousItemCount: Int = -1
    var currentPage: Int = 1

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (dy > 0) {
            val itemCount = linearLayoutManager.itemCount

            if (itemCount >= previousItemCount) {
                loading = false
            }

            if (!loading && linearLayoutManager.findLastVisibleItemPosition() >= itemCount - 1) {
                previousItemCount = itemCount
                currentPage++
                loading = onLoadMore(currentPage)
            }
        }

    }

    abstract fun onLoadMore(nextPage: Int): Boolean
}
