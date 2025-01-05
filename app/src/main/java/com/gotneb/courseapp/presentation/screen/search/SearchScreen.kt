package com.gotneb.courseapp.presentation.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
    onCourseClick: () -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // ======================
        // Header
        // ======================
        item(span = { GridItemSpan(2) }) {
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
        item(span = { GridItemSpan(2) }) {
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
        item(span = { GridItemSpan(2) }) {
            Text(
                text = "Result founds (17)",
                modifier = Modifier.fillMaxWidth()
            )
        }
        items(6) {
            CourseCard(onCourseClick)
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    CourseAppTheme {
        SearchScreen(
            state = SearchScreenState(),
            onValueChange = {},
            onCourseClick = {},
        )
    }
}