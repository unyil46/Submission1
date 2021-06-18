package org.djafa.submission1.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import org.djafa.submission1.data.MoviesEntity
import org.djafa.submission1.databinding.ActivityDetailMoviesBinding
import org.djafa.submission1.databinding.ContentDetailMoviesBinding

class DetailMoviesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailContentBinding: ContentDetailMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie((movieId))
                populateMovie(viewModel.getMovie() as MoviesEntity)
            }
        }
    }

    private fun populateMovie(movieEntity: MoviesEntity) {
        detailContentBinding.textTitleMv.text = movieEntity.title
        detailContentBinding.textOverviewMv.text = movieEntity.overview
        detailContentBinding.textRateMv.text = movieEntity.vote_average
        Glide.with(this)
            .load(movieEntity.poster_path)
            .transform(RoundedCorners(20))
            .into(detailContentBinding.imagePathMv)

    }
}