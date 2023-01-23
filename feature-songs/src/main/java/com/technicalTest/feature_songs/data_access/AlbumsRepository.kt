package com.technicalTest.feature_songs.data_access

import com.technicalTest.feature_songs.entity.Album

internal interface AlbumsRepository {
    suspend fun getAlbumsList(searchTerm: String): List<Album>
}