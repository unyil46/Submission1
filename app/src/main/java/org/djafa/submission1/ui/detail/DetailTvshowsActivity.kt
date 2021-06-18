package org.djafa.submission1.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import org.djafa.submission1.data.MoviesEntity
import org.djafa.submission1.databinding.ActivityDetailTvshowsBinding
import org.djafa.submission1.databinding.ContentDetailTvshowsBinding

class DetailTvshowsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailContentBinding: ContentDetailTvshowsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailTvshowsBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTvshowsViewModel::class.java]
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
        detailContentBinding.textTitleTv.text = movieEntity.title
        detailContentBinding.textOverviewTv.text = movieEntity.overview
        detailContentBinding.textRateTv.text = movieEntity.vote_average

        Glide.with(this)
            .load(movieEntity.poster_path)
            .transform(RoundedCorners(20))
            .into(detailContentBinding.imagePathTv)


    }
}