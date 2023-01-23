package com.technicalTest.feature_songs.domain.model

import com.technicalTest.feature_songs.entity.Album
import java.io.Serializable

data class Album(
    override val artistName: String,
    override val collectionName: String,
    override val collectionPrice: String?,
    override val currency: String,
    override val releaseDate: String?,
    override val pictureUrl: String,
    override val copyright: String?,
    override val primaryGenreName: String?
) : Album, Serializable