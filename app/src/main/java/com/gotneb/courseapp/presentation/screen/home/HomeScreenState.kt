package com.gotneb.courseapp.presentation.screen.home

import com.gotneb.courseapp.domain.model.CourseBookmarkModel
import com.gotneb.courseapp.domain.model.CourseModel

data class HomeScreenState(
    val selectedCategory: String = "all",
    val searchText: String = "",
    val categoriesCourses: List<CourseModel> = emptyList(),
    val isLoadingCategoriesCourses: Boolean = true,
    val popularCourses: List<CourseModel> = emptyList(),
    val isLoadingPopularCourses: Boolean = true,
    val bookmarkedCourses: List<CourseBookmarkModel> = emptyList(),
)
