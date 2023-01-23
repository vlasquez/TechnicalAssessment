package com.technicalTest.feature_songs.di

import com.technicalTest.feature_songs.data.AlbumsRepositoryImpl
import com.technicalTest.feature_songs.data.dataSource.AlbumsDataSource
import com.technicalTest.feature_songs.data.dataSource.remote.AlbumsRemoteDataSource
import com.technicalTest.feature_songs.data.dataSource.remote.ITunesAlbumsApi
import com.technicalTest.feature_songs.data_access.AlbumsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AlbumsModule {

    @Binds
    abstract fun providesAlbumsRepository(
        repository: AlbumsRepositoryImpl,
    ): AlbumsRepository

    @Binds
    abstract fun providesAlbumsDataSource(
        dataSource: AlbumsRemoteDataSource,
    ): AlbumsDataSource

    companion object {

        @Singleton
        @Provides
        fun provideITunesAlbumsApi(retrofit: Retrofit): ITunesAlbumsApi =
            retrofit.create(ITunesAlbumsApi::class.java)
    }
}