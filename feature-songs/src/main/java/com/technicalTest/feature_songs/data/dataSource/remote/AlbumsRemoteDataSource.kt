package com.technicalTest.feature_songs.data.dataSource.remote

import com.technicalTest.feature_songs.data.dataSource.AlbumsDataSource
import com.technicalTest.feature_songs.data.dataSource.remote.model.ITunesAlbumsResponse
import javax.inject.Inject

internal class AlbumsRemoteDataSource @Inject constructor(
    private val iTunesAlbumsApi: ITunesAlbumsApi,
) : AlbumsDataSource {
    override suspend fun getAlbums(term: String): Result<ITunesAlbumsResponse> {
        return iTunesAlbumsApi.getAlbums(term)
    }
}