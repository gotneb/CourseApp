package com.gotneb.courseapp.presentation.screen.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme
import com.gotneb.courseapp.presentation.ui.theme.Purple
import com.gotneb.courseapp.presentation.ui.theme.White

@Composable
fun Chip(
    text: String,
    onClick: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(100))
            .clickable{ onClick(text) }
            .background(Purple)
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            color = White,
        )
    }
}

@Preview
@Composable
private fun ChipPreview() {
    CourseAppTheme {
        Chip(
            "Coding",
            onClick = {},
        )
    }
}