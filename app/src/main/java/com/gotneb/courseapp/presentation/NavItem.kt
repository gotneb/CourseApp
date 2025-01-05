package com.gotneb.courseapp.presentation

import androidx.compose.ui.graphics.vector.ImageVector
import com.gotneb.courseapp.domain.util.Route

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: Route,
)
