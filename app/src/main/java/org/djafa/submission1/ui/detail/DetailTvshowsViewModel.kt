package org.djafa.submission1.ui.detail

import androidx.lifecycle.ViewModel
import org.djafa.submission1.data.MoviesEntity
import org.djafa.submission1.utils.DataDummy

class DetailTvshowsViewModel : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MoviesEntity? {
        var movie: MoviesEntity? = null
        for (movieEntity in DataDummy.generateDummyTvShows()) {
            if (movieEntity.id == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

}