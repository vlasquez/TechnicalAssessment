package com.technicalTest.feature_songs.data.dataSource.remote

import com.technicalTest.feature_songs.data.dataSource.remote.model.ITunesAlbumsResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ITunesAlbumsApi {

    @GET("search?media=music&entity=album&attribute=artistTerm")
    suspend fun getAlbums(@Query("term") keySearch: String): Result<ITunesAlbumsResponse>
}