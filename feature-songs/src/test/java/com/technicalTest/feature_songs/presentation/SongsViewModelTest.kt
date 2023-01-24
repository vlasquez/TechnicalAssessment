package com.technicalTest.feature_songs.presentation

import com.technicalTest.feature_songs.MainCoroutineRule
import com.technicalTest.feature_songs.domain.model.Album
import com.technicalTest.feature_songs.domain.usecase.GetAlbumsUseCase
import com.technicalTest.utils.test.assertItems
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
internal class SongsViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @MockK
    private lateinit var getSongsUseCase: GetAlbumsUseCase

    @InjectMockKs
    private lateinit var songsViewModel: SongsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        songsViewModel = SongsViewModel(getSongsUseCase)
    }

    @Test
    fun `GIVEN an artist name WHEN use case is called THEN return a list of Albums`() {
        runTest {
            coEvery { getSongsUseCase("") } returns listOf<Album>()

            songsViewModel.viewState.assertItems(
                SongsViewModel.ViewState.Loading,
                SongsViewModel.ViewState.SongListLoaded(emptyList())
            ) {
                songsViewModel.searchSong("")
            }

            coVerify { getSongsUseCase("") }
        }
    }

    @Test
    fun `GIVEN an artist name WHEN use case is called THEN return error`() {
        runTest {
            coEvery { getSongsUseCase("") } throws Exception("error")

            songsViewModel.viewState.assertItems(
                SongsViewModel.ViewState.Loading,
                SongsViewModel.ViewState.SongListError("error")
            ) {
                songsViewModel.searchSong("")
            }
        }
    }
}