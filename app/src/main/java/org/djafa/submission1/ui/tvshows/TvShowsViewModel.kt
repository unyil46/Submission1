package org.djafa.submission1.ui.tvshows

import androidx.lifecycle.ViewModel
import org.djafa.submission1.data.MoviesEntity
import org.djafa.submission1.utils.DataDummy

class TvShowsViewModel : ViewModel() {
    fun getTvSHows(): List<MoviesEntity> = DataDummy.generateDummyTvShows()
}