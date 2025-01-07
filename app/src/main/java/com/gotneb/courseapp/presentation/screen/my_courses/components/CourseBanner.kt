package com.gotneb.courseapp.presentation.screen.my_courses.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme
import com.gotneb.courseapp.R
import com.gotneb.courseapp.presentation.ui.theme.Gray
import com.gotneb.courseapp.presentation.ui.theme.GrayWhite
import com.gotneb.courseapp.presentation.ui.theme.Purple
import com.gotneb.courseapp.presentation.ui.theme.White

private val colorStops = arrayOf(
    0.0f to Color(0xFFD9D9D9).copy(alpha = 0.5f),
    0.98f to Color(0xFF323232)
)

@Composable
fun CourseBanner() {
    Box(
        modifier = Modifier.clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Brush.verticalGradient(
                    0.0f to Color.Transparent,
                    0.98f to Color(0xFF323232)
                ))
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = "Software Engineering",
                style = MaterialTheme.typography.titleLarge.copy(color = White)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "16 / 20 lessons",
                    style = MaterialTheme.typography.labelLarge.copy(color = Gray),
                )
                Text(
                    text = "80%",
                    style = MaterialTheme.typography.labelSmall.copy(color = White)
                )
            }
            Box {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .background(GrayWhite)
                        .fillMaxWidth()
                        .height(4.dp)
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .background(Purple)
                        .fillMaxWidth(0.8f)
                        .height(4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CourseBannerPreview() {
    CourseAppTheme {
        CourseBanner()
    }
}