package com.gotneb.courseapp.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.gotneb.courseapp.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Poppins")

val poppinsFontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider)
)

val AppTypography = Typography(
    bodyMedium = TextStyle( // For color 202244, 16sp
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = DarkBlue
    ),
    bodySmall = TextStyle( // For color BBBBBB, 14sp
        fontFamily = poppinsFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Gray
    ),
    labelLarge = TextStyle( // For chips (FFFFFF, 14sp, Regular)
        fontFamily = poppinsFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = White
    ),
    labelSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = Gray,
    ),
    headlineLarge = TextStyle( // For "Popular Courses" (202244, 20sp, Medium)
        fontFamily = poppinsFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        color = DarkBlue,
    ),
    headlineMedium = TextStyle( // For "Popular Courses" (202244, 20sp, Medium)
        fontFamily = poppinsFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        color = DarkBlue,
    ),
    headlineSmall = TextStyle( // For "Popular Courses" subtext (774DED, 14sp, Medium Italic)
        fontFamily = poppinsFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
        color = Purple
    ),
    titleLarge = TextStyle( // For banners (202244, 16sp, Medium)
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = DarkBlue
    ),
    titleMedium = TextStyle( // For banners subtext (774DED, 14sp, SemiBold)
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        color = Purple
    ),
    titleSmall = TextStyle( // For banners subtext (333333, 14sp, Regular)
        fontFamily = poppinsFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = DarkGray
    ),
    bodyLarge = TextStyle( // Search bar text (333333, 16sp, Regular)
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        color = DarkGray
    ),
)