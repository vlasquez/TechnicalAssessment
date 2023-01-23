package com.technicalTest.feature_songs.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import coil.request.ImageRequest
import com.technicalTest.feature.R
import com.technicalTest.feature_songs.domain.model.Album
import com.technicalTest.utils.compose.Chip
import com.technicalTest.utils.compose.ComposeTextStyles.Heading
import com.technicalTest.utils.compose.ComposeTextStyles.SubheadingSmall

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AlbumItem(album: Album) {

    val dialogState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .height(120.dp)
            .padding(12.dp, 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(4),
        onClick = { dialogState.value = true }
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(album.pictureUrl)
                        .apply {
                            placeholder(R.drawable.ic_android_black_24dp)
                        }.build(),
                    imageLoader = LocalContext.current.imageLoader,
                ),
                contentScale = ContentScale.Inside,
                contentDescription = null,
                modifier = Modifier.weight(0.4f, true)
            )
            Column(
                Modifier
                    .weight(1f, true)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = album.collectionName, style = Heading)
                album.releaseDate?.let { Text(text = it, style = SubheadingSmall) }
            }
        }
    }
    AlbumDialogView(album, dialogState)
}

@Composable
private fun AlbumDialogView(album: Album, dialogState: MutableState<Boolean>) {

    if (dialogState.value) {
        Dialog(
            onDismissRequest = { dialogState.value = false },
            content = {
                Card(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(1f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = album.collectionName, style = Heading)
                        Chip(backgroundColor = colorResource(id = R.color.green), content = {
                            Text(
                                text = "$${album.collectionPrice} + ${album.currency}",
                                fontWeight = FontWeight.Bold, color = Color.White
                            )
                        })
                        album.copyright?.let { Text(text = it, style = SubheadingSmall) }
                    }
                }
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }
}

@Composable
@Preview
fun AlbumItemPreview() {
    AlbumItem(
        album = Album(
            "ArtistName",
            "CollectionName",
            "$20.99",
            "USD",
            "2000-01-20",
            "",
            "",
            "Rock",
        ),
    )
}