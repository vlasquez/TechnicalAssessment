package com.technicalTest.feature_songs.presentation.compose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.technicalTest.feature.R
import com.technicalTest.feature_songs.domain.model.Album
import com.technicalTest.feature_songs.presentation.SongsViewModel
import com.technicalTest.utils.compose.ComposeTextStyles.SubheadingSmall


private const val EMPTY_SEARCH = ""

@Composable
fun SongListView() {
    val viewModel: SongsViewModel = viewModel()
    val viewState by viewModel.viewState.collectAsState()
    val albumList = remember { mutableStateOf(listOf<Album>()) }
    when (viewState) {
        is SongsViewModel.ViewState.Loading -> {}
        is SongsViewModel.ViewState.SongListLoaded -> {
            albumList.value =
                (viewState as SongsViewModel.ViewState.SongListLoaded).albumList as List<Album>
        }
        is SongsViewModel.ViewState.SongListError -> {
            val localContext = LocalContext.current
            Toast.makeText(
                localContext,
                (viewState as SongsViewModel.ViewState.SongListError).message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    val textState = remember { mutableStateOf(TextFieldValue(EMPTY_SEARCH)) }

    Column(Modifier.background(colorResource(id = R.color.background))) {
        SearchView(textState)
        ListView(albumList.value)
    }
    viewModel.searchSong(textState.value.text)
}

@Composable
fun ListView(albumList: List<Album>) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(albumList) { song ->
            AlbumItem(song)
        }
    }
}

@Composable
private fun SearchView(state: MutableState<TextFieldValue>) {
    var searchTerm = remember { mutableStateOf(state.value) }

    TextField(
        value = searchTerm.value,
        onValueChange = { value ->
            searchTerm.value = value
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = SubheadingSmall,
        leadingIcon = {
            IconButton(onClick = {
                state.value = searchTerm.value
            }) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            }
        },
        trailingIcon = {
            if (searchTerm.value != TextFieldValue(EMPTY_SEARCH)) {
                IconButton(
                    onClick = {
                        searchTerm.value =
                            TextFieldValue(EMPTY_SEARCH)
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = EMPTY_SEARCH,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        placeholder = {
            Text(
                stringResource(id = R.string.write_your_search_here),
                color = Color.White
            )
        },
        singleLine = true,
        shape = RectangleShape,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                state.value = searchTerm.value
            }
        ),
    )
}


@Composable
@Preview
fun SongListPreview() {
    SongListView()
}