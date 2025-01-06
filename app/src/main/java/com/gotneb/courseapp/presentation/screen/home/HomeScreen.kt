package com.gotneb.courseapp.presentation.screen.home

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.R
import com.gotneb.courseapp.presentation.screen.home.component.Chip
import com.gotneb.courseapp.presentation.screen.home.component.CourseBanner
import com.gotneb.courseapp.presentation.screen.home.component.CourseListItem
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme


// Mockup data
private val chips = listOf("All", "Language", "Design", "Coding", "AI")

@Composable
fun HomeScreen(
    state: HomeScreenState,
    onCourseClick: (Int) -> Unit,
    onCategorySelected: (String) -> Unit,
    onSearchChange: (String) -> Unit,
    onSearchClick: (String) -> Unit,
) {
    if (state.isLoadingPopularCourses || state.isLoadingCategoriesCourses) {
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
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // =================================
        // Header
        // =================================
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.pfp),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(100))
                )
                Column {
                    Text(text = "Hey, Jane")
                    Text(text = "Find your favorites courses.")
                }
            }
        }
        // =================================
        // Search bar
        // =================================
        item {
            TextField(
                value = state.searchText,
                onValueChange = onSearchChange,
                placeholder = {
                    Text(text = "I would like to learn...")
                },
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
        // =================================
        // Tags sliders
        // =================================
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(chips) { chipText ->
                    Chip(
                        chipText,
                        onClick = onCategorySelected,
                    )
                }
            }
        }
        // =================================
        // Course banners
        // =================================
        item {
            val bannerWidth = (screenWidth * 0.75).dp // 80% of screen width
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(state.categoriesCourses) { c ->
                    CourseBanner(
                        course = c,
                        onClick = onCourseClick,
                        modifier = Modifier.width(bannerWidth),
                    )
                }
            }
        }
        // =================================
        // Popular courses
        // =================================
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Popular courses")
                TextButton(onClick = {}) {
                    Text(text = "See all")
                }
            }
        }
        items(state.popularCourses) { course ->
            CourseListItem(
                course = course,
                onClick = onCourseClick,
            )
        }
    }
}


@Preview(
    showBackground = true,
    name = "Home"
)

@Composable
private fun HomeScreenPreview() {
    CourseAppTheme {
        HomeScreen(
            state = HomeScreenState(
                isLoadingPopularCourses = true,
            ),
            onCourseClick = {},
            onSearchChange = {},
            onSearchClick = {},
            onCategorySelected = {},
        )
    }
}