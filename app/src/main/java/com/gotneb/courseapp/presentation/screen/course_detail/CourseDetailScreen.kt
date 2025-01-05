package com.gotneb.courseapp.presentation.screen.course_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme
import com.gotneb.courseapp.R
import com.gotneb.courseapp.presentation.screen.course_detail.components.LessonCard

@Composable
fun CourseDetailScreen(
    state: CourseDetailState,
    onBookmarkClick: () -> Unit,
    onReturnClick: () -> Unit,
) {
    Scaffold { padding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                    ,
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
                    Text(text = "Course Details")
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(100))
                            .background(Color.Gray)
                            .padding(4.dp)
                    )
                }
            }
            item {
                Surface(
                    shadowElevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.background),
                        contentDescription = null,
                        modifier = Modifier.clip(RoundedCornerShape(8.dp))
                    )
                }
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = "Jetpack Compose Kotlin Programming, Coroutine",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(text = "$459")
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.pfp),
                        contentDescription = "Instructor's photo",
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .size(48.dp)
                            .clip(RoundedCornerShape(100))
                    )
                    Text(text = "Jane Doe")
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Instructor's rating",
                    )
                    Text(text = "4.8")
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Enrolled people",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Text(text = "778")
                }
            }
            item {
                Column {
                    Text(text = "Description")
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Learn Kotlin, a modern programming language that runs on the Java  Virtual Machine. Acquire expertise in syntax, concurrency, and Android  development to build modern Android applications with Kotlin for  efficient and expressive coding, essential.",
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
            item {
                Text(text = "15 Lessons")
            }
            items(5) {
                LessonCard()
            }
        }
    }
}

@Preview
@Composable
private fun CourseDetailScreenPreview() {
    CourseAppTheme {
        CourseDetailScreen(
            state = CourseDetailState(),
            onBookmarkClick = {},
            onReturnClick = {},
        )
    }
}