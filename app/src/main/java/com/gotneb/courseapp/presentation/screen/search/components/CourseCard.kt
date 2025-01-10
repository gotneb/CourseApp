package com.gotneb.courseapp.presentation.screen.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.gotneb.courseapp.R
import com.gotneb.courseapp.domain.model.CourseModel
import com.gotneb.courseapp.presentation.ui.theme.Purple

fun String.capitalize(): String {
    return this.replaceFirstChar { it.uppercase() }
}

@Composable
fun CourseCard(
    course: CourseModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.clickable{ onClick() }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(8.dp)
        ) {
            AsyncImage(
                model = course.thumbnailUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5))
            )
            Text(
                text = course.tags.first().capitalize(),
                style = MaterialTheme.typography.titleSmall.copy(color = Purple),
            )
            Text(
                text = course.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = course.instructor.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    text = "$${course.price}",
                    style = MaterialTheme.typography.titleLarge.copy(color = Purple, fontWeight = FontWeight.SemiBold)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun CourseCardPreview() {
//    CourseAppTheme {
//        CourseCard(
//            onClick = {},
//        )
//    }
//}