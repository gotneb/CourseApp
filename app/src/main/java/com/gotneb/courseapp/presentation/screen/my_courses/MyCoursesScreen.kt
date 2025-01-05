package com.gotneb.courseapp.presentation.screen.my_courses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.presentation.screen.my_courses.components.CourseBanner
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme

@Composable
fun MyCoursesScreen(
    state: MyCoursesState,
    onSearchChange: (String) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "My Courses")
            }
        }
        item {
            TextField(
                value = state.searchText,
                onValueChange = onSearchChange,
                placeholder = {
                    Text(text = "Search for your course...")
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
                    .padding(bottom = 8.dp)
            )
        }
        items(5) {
            CourseBanner()
        }
    }
}

@Preview
@Composable
private fun MyCoursesScreenPreview() {
    CourseAppTheme {
        MyCoursesScreen(
            state = MyCoursesState(),
            onSearchChange = {},
        )
    }
}