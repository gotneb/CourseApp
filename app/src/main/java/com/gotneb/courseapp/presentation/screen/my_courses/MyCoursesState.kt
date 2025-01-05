package com.gotneb.courseapp.presentation.screen.my_courses

import com.gotneb.courseapp.domain.model.CourseModel

data class MyCoursesState(
    val searchText: String = "",
    val ongoingCourses: List<CourseModel> = emptyList(),
)