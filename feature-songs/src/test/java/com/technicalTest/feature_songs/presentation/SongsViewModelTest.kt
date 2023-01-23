package com.technicalTest.feature_songs.presentation

import com.technicalTest.feature_songs.domain.usecase.GetAlbumsUseCase
import io.mockk.impl.annotations.MockK
import org.junit.After


internal class SongsViewModelTest {

    @MockK
    private lateinit var getSongsUseCase: GetAlbumsUseCase



    @After
    fun setUp() {
    }
}