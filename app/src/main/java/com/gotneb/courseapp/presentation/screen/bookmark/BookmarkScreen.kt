package com.gotneb.courseapp.presentation.screen.bookmark

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.presentation.screen.home.component.Chip
import com.gotneb.courseapp.presentation.screen.home.component.CourseBanner

val categories = listOf("All", "Language", "Design", "Coding", "AI")

@Composable
fun BookmarkScreen(
    state: BookmarkScreenState,
    onValueChange: (String) -> Unit,
    onSearchClick: (String) -> Unit,
    onClick: (Int) -> Unit,
    onBookmarkClick: (Int) -> Unit,
    onCategoryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    if (state.isLoading) {
        return Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            CircularProgressIndicator(modifier = Modifier.size(48.dp))
        }
    }

    val screenWidth = LocalConfiguration.current.screenWidthDp

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
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
                Text(
                    text = "Bookmarks",
                    style = MaterialTheme.typography.headlineMedium,
                )
            }
        }
        // =====================
        // Search bar
        // =====================
        item() {
            TextField(
                value = state.searchText,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        text = "Search your course...",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                },
                textStyle = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.clickable{ onSearchClick(state.searchText) }
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
                    Chip(
                        category,
                        onClick = onCategoryChange,
                    )
                }
            }
        }
        // =====================
        // Courses
        // =====================
        items(state.filteredCourses) { c ->
            CourseBanner(
                course = c,
                onClick = onClick,
                onBookmarkClick = onBookmarkClick,
                modifier = Modifier.width(screenWidth.dp),
            )
        }
    }
}

//@Preview
//@Composable
//private fun BookmarkScreenPreview() {
//    CourseAppTheme {
//        BookmarkScreen()
//    }
//}