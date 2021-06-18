package org.djafa.submission1.ui.movies

import androidx.lifecycle.ViewModel
import org.djafa.submission1.data.MoviesEntity
import org.djafa.submission1.utils.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies(): List<MoviesEntity> = DataDummy.generateDummyMovies()
}