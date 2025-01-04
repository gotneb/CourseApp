package com.gotneb.courseapp.presentation.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.R
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme


@Composable
fun CourseBanner(modifier: Modifier = Modifier) {
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(8.dp)
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
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                ) {
                    // Rating
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(100))
                            .background(Color.White)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                            )
                            Text(text = "4.8 (742)")
                        }
                    }
                    // Bookmark button
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(100))
                            .background(Color.White)
                            .padding(4.dp)
                    )
                }
            }
            // Title
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Machine Learning")
                Text(text = "$459")
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
                Text(text = "Jane Doe")
            }
            // Details
            Row {
                Text(text = "14 lessons • 8h 56min")
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "Course Banner"
)
@Composable
private fun CourseBannerPreview() {
    CourseAppTheme {
        CourseBanner(modifier =  Modifier.fillMaxWidth())
    }
}