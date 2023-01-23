package com.technicalTest.feature_songs.data

import com.technicalTest.feature_songs.data.dataSource.AlbumsDataSource
import com.technicalTest.feature_songs.data_access.AlbumsRepository
import com.technicalTest.feature_songs.domain.mapper.AlbumsMapper
import com.technicalTest.feature_songs.entity.Album
import javax.inject.Inject

internal class AlbumsRepositoryImpl @Inject constructor(
    private val remoteDataSource: AlbumsDataSource,
    private val albumsMapper: AlbumsMapper
) : AlbumsRepository {

    override suspend fun getAlbumsList(searchTerm: String): List<Album> {
        val result = remoteDataSource.getAlbums(searchTerm)

        return albumsMapper.transform(result.getOrThrow())
    }
}