package com.gotneb.courseapp.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class SearchCourseResponseModel(
    val total: Int,
    val error: String?,
    val data: List<CourseModel>,
)
