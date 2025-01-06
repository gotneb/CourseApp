package com.gotneb.courseapp.presentation.screen.course_detail

import com.gotneb.courseapp.domain.model.CourseModel

data class CourseDetailState(
    val isLoading: Boolean = true,
    val course: CourseModel? = null,
)
