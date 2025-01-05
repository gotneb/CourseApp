package com.gotneb.courseapp.presentation.screen.course_detail

import com.gotneb.courseapp.domain.model.CourseModel

data class CourseDetailState(
    val isLoading: Boolean = false,
    val course: CourseModel? = null,
)
