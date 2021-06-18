package org.djafa.submission1.data

data class MoviesEntity(
    var id: String? = null,
    var title: String? = null,
    var overview: String? = null,
    var poster_path: String? = null,
    var release_date: String? = null,
    var vote_average: String? = null
)