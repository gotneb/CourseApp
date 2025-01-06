package com.gotneb.courseapp.presentation.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.presentation.screen.search.components.CourseCard
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme

@Composable
fun SearchScreen(
    state: SearchScreenState,
    onValueChange: (String) -> Unit,
    onCourseClick: (Int) -> Unit,
    onSearchClick: () -> Unit,
    onReturnClick: () -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(if (state.isLoading) 1 else 2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // ======================
        // Header
        // ======================
        item(span = { GridItemSpan(if (state.isLoading) 1 else 2) }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
            ) {
                Icon(
                    // くそおめんどくせいな「Android Studio」
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .clickable{ onReturnClick() }
                        .background(Color.Gray)
                        .padding(4.dp)
                )
                Spacer(Modifier.weight(1f))
                Text(text = "Search")
                Spacer(Modifier.weight(1f))
            }
        }
        // ======================
        // Search bar
        // ======================
        item(span = { GridItemSpan(if (state.isLoading) 1 else 2) }) {
            TextField(
                value = state.searchText,
                onValueChange = onValueChange,
                placeholder = {
                    Text(text = "I would like to learn...")
                },
                maxLines = 1,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.clickable{ onSearchClick() }
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
        // ======================
        // Results
        // ======================
        if (state.isLoading) {
            item {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        } else {
            item(span = { GridItemSpan(2) }) {
                Text(
                    text = "Result founds (${state.courses.size})",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            items(state.courses) { c ->
                CourseCard(
                    course = c,
                    onClick = { onCourseClick(c.id) },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    CourseAppTheme {
        SearchScreen(
            state = SearchScreenState(isLoading = true),
            onValueChange = {},
            onCourseClick = {},
            onSearchClick = {},
            onReturnClick = {},
        )
    }
}