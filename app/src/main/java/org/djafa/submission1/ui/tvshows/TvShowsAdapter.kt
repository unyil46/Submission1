package org.djafa.submission1.ui.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.djafa.submission1.R
import org.djafa.submission1.data.MoviesEntity
import org.djafa.submission1.databinding.ItemsMoviesBinding
import org.djafa.submission1.ui.detail.DetailMoviesActivity
import org.djafa.submission1.ui.detail.DetailTvshowsActivity

class TvShowsAdapter : RecyclerView.Adapter<TvShowsAdapter.MoviesViewHolder>() {
    private var listMovies = ArrayList<MoviesEntity>()
    fun setMovies(movies: List<MoviesEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMoviesBinding =
            ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    class MoviesViewHolder(private val binding: ItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MoviesEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemRate.text = movie.vote_average
                tvItemOver.text = movie.overview?.take(100)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvshowsActivity::class.java)
                    intent.putExtra(DetailMoviesActivity.EXTRA_MOVIE, movie.id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movie.poster_path)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_foreground)
                    )
                    .into(imgPath)
            }
        }
    }
}