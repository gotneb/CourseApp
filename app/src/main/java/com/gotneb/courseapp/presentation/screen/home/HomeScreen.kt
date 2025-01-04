package com.gotneb.courseapp.presentation.screen.home

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme
import com.gotneb.courseapp.R
import com.gotneb.courseapp.presentation.screen.home.component.Chip
import com.gotneb.courseapp.presentation.screen.home.component.CourseBanner
import com.gotneb.courseapp.presentation.screen.home.component.CourseListItem


// Mockup data
private val chips = listOf("All", "Language", "Design", "Coding", "AI")

@Composable
fun HomeScreen(
    state: HomeScreenState,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    Scaffold { padding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(20.dp)
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
                    value = "",
                    onValueChange = { },
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
            // =================================
            // Tags sliders
            // =================================
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(chips) { chipText ->
                        Chip(chipText)
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
                    items(2) {
                        CourseBanner(modifier = Modifier.width(bannerWidth))
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
            items(5) {
                CourseListItem()
            }
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
            state = HomeScreenState()
        )
    }
}