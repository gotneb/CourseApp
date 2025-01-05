package com.gotneb.courseapp.presentation.screen.bookmark

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.presentation.screen.home.component.Chip
import com.gotneb.courseapp.presentation.screen.home.component.CourseBanner
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme

val categories = listOf("All", "Language", "Design", "Coding", "AI")

@Composable
fun BookmarkScreen(modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    Scaffold { padding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // =====================
            // Item
            // =====================
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(text = "Bookmarks")
                }
            }
            // =====================
            // Search bar
            // =====================
            item() {
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(text = "Search your course...")
                    },
                    maxLines = 1,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(100))
                )
            }
            // =====================
            // Categories
            // =====================
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(categories) { category ->
                        Chip(category)
                    }
                }
            }
            // =====================
            // Courses
            // =====================
            items(4) {
                CourseBanner(modifier = Modifier.width(screenWidth.dp))
            }
        }
    }
}

@Preview
@Composable
private fun BookmarkScreenPreview() {
    CourseAppTheme {
        BookmarkScreen()
    }
}