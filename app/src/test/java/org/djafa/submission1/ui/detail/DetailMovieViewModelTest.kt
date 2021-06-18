package org.djafa.submission1.ui.detail

import org.djafa.submission1.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId: String = dummyMovie.id.toString()

    @Test
    fun setSelectedMovie() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
        val moviesEntity = viewModel.getMovie()
        assertNotNull(moviesEntity)
        assertEquals(dummyMovie.id, moviesEntity?.id)
        assertEquals(dummyMovie.title, moviesEntity?.title)
        assertEquals(dummyMovie.vote_average, moviesEntity?.vote_average)
        assertEquals(dummyMovie.overview, moviesEntity?.overview)
    }
}