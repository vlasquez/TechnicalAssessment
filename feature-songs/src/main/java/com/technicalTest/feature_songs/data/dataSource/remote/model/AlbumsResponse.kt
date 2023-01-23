package com.technicalTest.feature_songs.data.dataSource.remote.model

import com.google.gson.annotations.SerializedName

internal data class AlbumsResponse(
    @SerializedName("artistName")
    val artistName: String,

    @SerializedName("artworkUrl100")
    val pictureUrl: String,

    @SerializedName("collectionName")
    val collectionName: String,

    @SerializedName("collectionPrice")
    val collectionPrice: String?,

    @SerializedName("currency")
    val currency: String,

    @SerializedName("releaseDate")
    val releaseDate: String?,

    @SerializedName("copyright")
    val copyright: String?,

    @SerializedName("primaryGenreName")
    val primaryGenreName: String?
)
