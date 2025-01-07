package com.gotneb.courseapp.presentation.screen.bookmark

import com.gotneb.courseapp.domain.model.CourseModel

data class BookmarkScreenState(
    val searchText: String = "",
    val isLoading: Boolean = true,
    val selectedCategory: String = "All",
    val courses: List<CourseModel> = emptyList(),
    val filteredCourses: List<CourseModel> = emptyList(),
)
