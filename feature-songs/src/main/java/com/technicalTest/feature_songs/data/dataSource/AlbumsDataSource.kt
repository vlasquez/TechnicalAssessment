package com.technicalTest.feature_songs.data.dataSource

import com.technicalTest.feature_songs.data.dataSource.remote.model.ITunesAlbumsResponse

internal interface AlbumsDataSource {
    suspend fun getAlbums(term: String): Result<ITunesAlbumsResponse>
}