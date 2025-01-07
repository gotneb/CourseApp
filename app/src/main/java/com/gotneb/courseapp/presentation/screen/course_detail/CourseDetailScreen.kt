package com.gotneb.courseapp.presentation.screen.course_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.R
import com.gotneb.courseapp.presentation.screen.course_detail.components.LessonCard

@Composable
fun CourseDetailScreen(
    state: CourseDetailState,
    onBookmarkClick: (Int) -> Unit,
    onReturnClick: () -> Unit,
) {
    LazyColumn(
        verticalArrangement = if (state.isLoading) Arrangement.Center else Arrangement.spacedBy(16.dp),
        horizontalAlignment = if (state.isLoading) Alignment.CenterHorizontally else Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (state.isLoading) {
            item {
                CircularProgressIndicator(modifier = Modifier.size(48.dp))
            }
        } else {
            item {
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
                            .clickable { onReturnClick() }
                            .background(Color.Gray)
                            .padding(4.dp)
                    )
                    Spacer(Modifier.weight(1f))
                    Text(text = "Course Details")
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = if (state.course!!.isBookmarked!!) Icons.Filled.Favorite
                        else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(100))
                            .clickable { onBookmarkClick(state.course.id) }
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
                        text = state.course!!.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(text = "$${state.course.price}")
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
                    Text(text = state.course!!.instructor.name)
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Instructor's rating",
                    )
                    Text(text = "${state.course.rating}")
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Enrolled people",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Text(text = "${state.course.enrolledPeople}")
                }
            }
            item {
                Column {
                    Text(text = "Description")
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = state.course!!.description,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
            item {
                Text(text = "${state.course!!.lessons.size} Lessons")
            }
            items(state.course!!.lessons) { lesson ->
                LessonCard(lesson)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun CourseDetailScreenPreview() {
//    CourseAppTheme {
//        CourseDetailScreen(
//            state = CourseDetailState(isLoading = false),
//            onBookmarkClick = {},
//            onReturnClick = {},
//        )
//    }
//}