package com.gotneb.courseapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CourseModel(
    val id: Int,
    val instructorId: Int,
    val title: String,
    val thumbnailUrl: String,
    val rating: Double,
    val enrolledPeople: Int,
    val description: String,
    val tags: List<String>,
    val lessons: List<LessonModel>
)
