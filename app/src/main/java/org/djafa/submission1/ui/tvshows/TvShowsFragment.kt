package org.djafa.submission1.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.djafa.submission1.databinding.FragmentTvShowsBinding

class TvShowsFragment : Fragment() {
   lateinit var fragmentTvMoviesBinding:FragmentTvShowsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        fragmentTvMoviesBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowsViewModel::class.java]
            val tvshows = viewModel.getTvSHows()

            val tvshowAdapter = TvShowsAdapter()
            tvshowAdapter.setMovies(tvshows)

            with(fragmentTvMoviesBinding.rvTvshows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = tvshowAdapter
            }
        }
    }
}