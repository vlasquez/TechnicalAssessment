package com.technicalTest.feature_songs.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technicalTest.feature_songs.domain.usecase.GetAlbumsUseCase
import com.technicalTest.feature_songs.entity.Album
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SongsViewModel @Inject constructor(
    private val getSongsUseCase: GetAlbumsUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow<ViewState>(ViewState.Loading)

    val viewState: StateFlow<ViewState> get() = _viewState

    fun searchSong(searchTerm: String) {
        viewModelScope.launch {
            runCatching {
                getSongsUseCase(searchTerm)
            }.onSuccess {
                _viewState.value = ViewState.SongListLoaded(it)
            }.onFailure {
                _viewState.value = ViewState.SongListError(it.message)
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class SongListLoaded(val albumList: List<Album>) : ViewState()
        data class SongListError(val message: String?) : ViewState()
    }

    sealed class Event {
        data class ShowSongDetails(val album: Album) : Event()
    }
}