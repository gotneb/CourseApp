package com.gotneb.courseapp.presentation.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.R
import com.gotneb.courseapp.domain.model.CourseModel
import com.gotneb.courseapp.domain.model.LessonModel
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme
import com.gotneb.courseapp.presentation.ui.theme.DarkBlue
import com.gotneb.courseapp.presentation.ui.theme.Orange
import com.gotneb.courseapp.presentation.ui.theme.Purple

fun List<LessonModel>.totalDuration(): String {
    val totalMinutes = this.sumOf { it.duration } / 60
    val hours = totalMinutes / 60
    val minutes = totalMinutes % 60

    return when {
        hours > 0 && minutes > 0 -> "${hours}h ${minutes}min"
        hours > 0 -> "${hours}h"
        else -> "${minutes}min"
    }
}

@Composable
fun CourseBanner(
    course: CourseModel,
    onClick: (Int) -> Unit,
    onBookmarkClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(shadowElevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.clickable { onClick(course.id) }) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(8.dp),
        ) {
            // Image Header
            Box(
                modifier = modifier
            ) {
                Image(
                    painter = painterResource(R.drawable.bg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .height(200.dp)
                        .clip(RoundedCornerShape(6))
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier
                ) {
                    // Rating
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(100))
                            .background(Color.White)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Orange,
                            )
                            Spacer(Modifier.width(2.dp))
                            Text(
                                text = "${course.rating}",
                                style = MaterialTheme.typography.labelSmall.copy(color = Orange),
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = "(${course.enrolledPeople})",
                                style = MaterialTheme.typography.labelSmall,
                            )
                        }
                    }
                    // Bookmark button
                    Icon(imageVector = if (course.isBookmarked!!) Icons.Filled.Favorite
                    else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = if (course.isBookmarked) Orange else DarkBlue,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { onBookmarkClick(course.id) }
                            .clip(RoundedCornerShape(100))
                            .background(Color.White)
                            .padding(4.dp))
                }
            }
            // Title
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = course.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "$${course.price}",
                    style = MaterialTheme.typography.titleLarge.copy(color = Purple, fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.padding(start = 8.dp),
                )
            }
            // Instructor
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.pfp),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(100))
                )
                Text(
                    text = course.instructor.name,
                    style = MaterialTheme.typography.titleSmall
                )
            }
            // Details
            Row {
                Text(
                    text = "${course.lessons.size} lessons • ${course.lessons.totalDuration()}",
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    }
}

//@Preview(
//    showBackground = true,
//    name = "Course Banner"
//)
//@Composable
//private fun CourseBannerPreview() {
//    CourseAppTheme {
//        CourseBanner(modifier =  Modifier.fillMaxWidth())
//    }
//}