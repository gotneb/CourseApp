package com.gotneb.courseapp.presentation.screen.bookmark

import com.gotneb.courseapp.domain.model.CourseModel

data class BookmarkScreenState(
    val isLoading: Boolean = true,
    val courses: List<CourseModel> = emptyList(),
)
