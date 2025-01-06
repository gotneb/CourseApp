package com.gotneb.courseapp.presentation.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.R
import com.gotneb.courseapp.domain.model.CourseModel

@Composable
fun CourseListItem(
    course: CourseModel,
    onClick: (Int) -> Unit,
) {
    Surface(
        shadowElevation = 6.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.clickable{ onClick(course.id) }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.bg),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .height(84.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth().weight(1f)
            ) {
                Text(
                    text = course.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(R.drawable.pfp),
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(100))
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(text = course.instructor.name)
                }
                Text(text = "${course.lessons.size} lessons • ${course.lessons.totalDuration()}")
            }
            Text(text = "${course.price}")
        }
    }
}
//
//@Preview
//@Composable
//private fun CourseListItemPreview() {
//    CourseAppTheme {
//        CourseListItem()
//    }
//}