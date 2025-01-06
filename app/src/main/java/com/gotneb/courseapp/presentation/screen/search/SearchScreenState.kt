package com.gotneb.courseapp.presentation.screen.search

import com.gotneb.courseapp.domain.model.CourseModel

data class SearchScreenState(
    val searchText: String = "",
    val isLoading: Boolean = true,
    val courses: List<CourseModel> = emptyList(),
)
