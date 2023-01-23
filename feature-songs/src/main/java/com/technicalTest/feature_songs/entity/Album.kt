package com.technicalTest.feature_songs.entity

interface Album {
    val artistName: String
    val collectionName: String?
    val collectionPrice: String?
    val currency: String
    val releaseDate: String?
    val pictureUrl: String
    val copyright: String?
    val primaryGenreName: String?
}
