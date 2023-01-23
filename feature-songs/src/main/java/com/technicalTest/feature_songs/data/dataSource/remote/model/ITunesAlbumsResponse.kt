package com.technicalTest.feature_songs.data.dataSource.remote.model

import com.google.gson.annotations.SerializedName

internal data class ITunesAlbumsResponse(
    @SerializedName("resultCount")
    val resultCount: Int,

    @SerializedName("results")
    val results: List<AlbumsResponse>
)
