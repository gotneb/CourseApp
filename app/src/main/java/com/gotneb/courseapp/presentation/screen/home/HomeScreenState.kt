package com.gotneb.courseapp.presentation.screen.home

import com.gotneb.courseapp.domain.model.CourseModel

data class HomeScreenState(
    val categoriesCourses: List<CourseModel> = emptyList(),
    val isLoadingCategoriesCourses: Boolean = false,
    val popularCourses: List<CourseModel> = emptyList(),
    val isLoadingPopularCourses: Boolean = false,
)
