package com.technicalTest.feature_songs.domain.usecase

import com.technicalTest.feature_songs.data_access.AlbumsRepository
import com.technicalTest.feature_songs.entity.Album
import dagger.Reusable
import javax.inject.Inject

@Reusable
internal class GetAlbumsUseCase @Inject constructor(private val albumsRepository: AlbumsRepository) {

    suspend operator fun invoke(searchTerm: String): List<Album> =
        albumsRepository.getAlbumsList(searchTerm)

}