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
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.R
import com.gotneb.courseapp.presentation.screen.course_detail.components.LessonCard
import com.gotneb.courseapp.presentation.ui.theme.DarkBlue
import com.gotneb.courseapp.presentation.ui.theme.DarkBlue2
import com.gotneb.courseapp.presentation.ui.theme.DarkGray
import com.gotneb.courseapp.presentation.ui.theme.Orange
import com.gotneb.courseapp.presentation.ui.theme.Purple
import com.gotneb.courseapp.presentation.ui.theme.WhiteSnow

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
                        tint = if (state.course!!.isBookmarked!!) DarkBlue2 else LocalContentColor.current,
                        modifier = Modifier
                            .clip(RoundedCornerShape(100))
                            .clickable { onReturnClick() }
                            .background(WhiteSnow)
                            .padding(4.dp)
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "Course Details",
                        style = MaterialTheme.typography.headlineMedium,
                    )
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = if (state.course.isBookmarked) Icons.Filled.Favorite
                        else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = if (state.course.isBookmarked) DarkBlue2 else LocalContentColor.current,
                        modifier = Modifier
                            .clip(RoundedCornerShape(100))
                            .clickable { onBookmarkClick(state.course.id) }
                            .background(WhiteSnow)
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
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.headlineLarge,
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        text = "$${state.course.price}",
                        style = MaterialTheme.typography.titleLarge.copy(color = Purple, fontWeight = FontWeight.SemiBold)
                    )
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
                    Text(
                        text = state.course!!.instructor.name,
                        style = MaterialTheme.typography.titleLarge,
                    )
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.Star,
                        tint = Orange,
                        contentDescription = "Instructor's rating",
                    )
                    Text(
                        text = "${state.course.rating}",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Enrolled people",
                        tint = DarkBlue,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Text(
                        text = "${state.course.enrolledPeople}",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
            item {
                Column {
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.titleLarge,
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = state.course!!.description,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodySmall.copy(color = DarkGray),
                    )
                }
            }
            item {
                Text(
                    text = "${state.course!!.lessons.size} Lessons",
                    style = MaterialTheme.typography.titleLarge,
                )
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