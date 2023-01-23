package com.technicalTest.feature_songs.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.window.Dialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.technicalTest.feature_songs.presentation.compose.SongListView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class ITunesAlbumListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            SongListView()
        }
    }
}