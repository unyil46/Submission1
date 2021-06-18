package org.djafa.submission1.ui.tvshows

import org.djafa.submission1.ui.movies.MoviesViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowsViewModelTest {
    private lateinit var viewModel: TvShowsViewModel

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel()

    }

    @Test
    fun getMovies() {
        val moviesEntities = viewModel.getTvSHows()
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities.size)
    }
}