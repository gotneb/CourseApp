package com.gotneb.courseapp.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val AppTypography = Typography(
    bodyMedium = TextStyle( // For color 202244, 16sp
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = DarkBlue
    ),
    bodySmall = TextStyle( // For color BBBBBB, 14sp
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Gray
    ),
    labelLarge = TextStyle( // For chips (FFFFFF, 14sp, Regular)
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = White
    ),
    labelSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = Gray,
    ),
    headlineLarge = TextStyle( // For "Popular Courses" (202244, 20sp, Medium)
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        color = DarkBlue,
    ),
    headlineMedium = TextStyle( // For "Popular Courses" (202244, 20sp, Medium)
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        color = DarkBlue,
    ),
    headlineSmall = TextStyle( // For "Popular Courses" subtext (774DED, 14sp, Medium Italic)
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
        color = Purple
    ),
    titleLarge = TextStyle( // For banners (202244, 16sp, Medium)
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = DarkBlue
    ),
    titleMedium = TextStyle( // For banners subtext (774DED, 14sp, SemiBold)
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        color = Purple
    ),
    titleSmall = TextStyle( // For banners subtext (333333, 14sp, Regular)
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = DarkGray
    ),
    bodyLarge = TextStyle( // Search bar text (333333, 16sp, Regular)
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = DarkGray
    ),
)