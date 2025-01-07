package com.gotneb.courseapp.presentation.screen.course_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.domain.model.LessonModel
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme
import com.gotneb.courseapp.presentation.ui.theme.DarkGray
import com.gotneb.courseapp.presentation.ui.theme.Purple
import com.gotneb.courseapp.presentation.ui.theme.White

fun Int.toTimeFormat(): String {
    val minutes = this / 60
    val seconds = this % 60
    return "%02d:%02d".format(minutes, seconds)
}

@Composable
fun LessonCard(lesson: LessonModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .border(
                width = 1.dp,
                color = DarkGray,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier.padding(end = 12.dp)
                .clip(RoundedCornerShape(100))
                .background(Purple)
                .padding(4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                tint = White,
            )
        }
        Text(
            text = lesson.title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.weight(1f),
        )
        Spacer(Modifier.weight(.08f))
        Text(
            text = lesson.duration.toTimeFormat(),
            style = MaterialTheme.typography.titleSmall,
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun LessonCardPreview() {
//    CourseAppTheme {
//        LessonCard()
//    }
//}