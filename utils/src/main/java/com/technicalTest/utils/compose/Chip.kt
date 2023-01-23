package com.technicalTest.utils.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.technicalTest.utils.compose.ComposeTextStyles.Tiny

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 6.dp),
            ).padding(horizontal = 6.dp),
    ) {
        content()
    }
}

@Preview(showBackground = false)
@Composable
fun ChipPreview() {
    Chip(
        modifier = Modifier,
        backgroundColor = Color.Blue,
        content = {
            Text(
                text = "Sample Text",
                color = Color.White,
                style = Tiny,
                maxLines = 1,
            )
        },
    )
}