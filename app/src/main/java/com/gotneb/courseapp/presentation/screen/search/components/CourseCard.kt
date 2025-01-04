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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme
import com.gotneb.courseapp.R

@Composable
fun CourseCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.clickable{ onClick() }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.bg),
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(5))
            )
            Text(text = "Language")
            Text(
                text = "Online German Course. Learn how to talk.",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Deutsch Academy",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(12.dp))
                Text(text = "$599")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CourseCardPreview() {
    CourseAppTheme {
        CourseCard(
            onClick = {},
        )
    }
}