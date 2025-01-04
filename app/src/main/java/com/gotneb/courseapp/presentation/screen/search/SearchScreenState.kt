package com.gotneb.courseapp.presentation.screen.search

import com.gotneb.courseapp.domain.model.SearchCourseResponseModel

data class SearchScreenState(
    val searchText: String = "",
    val isLoading: Boolean = false,
    val courses: List<SearchCourseResponseModel> = emptyList(),
)
