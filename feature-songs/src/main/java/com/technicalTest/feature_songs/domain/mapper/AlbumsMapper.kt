package com.technicalTest.feature_songs.domain.mapper

import com.technicalTest.feature_songs.data.dataSource.remote.model.ITunesAlbumsResponse
import com.technicalTest.feature_songs.domain.model.Album
import com.technicalTest.utils.formatDate
import com.technicalTest.utils.fromMillisToMinutes
import javax.inject.Inject

internal class AlbumsMapper @Inject constructor() {
    fun transform(input: ITunesAlbumsResponse): List<Album> =
        input.results.map {
            Album(
                artistName = it.artistName,
                collectionName = it.collectionName,
                collectionPrice = it.collectionPrice,
                currency = it.currency,
                releaseDate = it.releaseDate?.let { releaseDate -> formatDate(releaseDate) },
                pictureUrl = it.pictureUrl,
                copyright = it.copyright,
                primaryGenreName = it.primaryGenreName
            )
        }
}
