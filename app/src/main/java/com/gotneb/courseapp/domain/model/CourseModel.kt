package com.gotneb.courseapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseModel(
    val id: Int,
    val instructor: InstructorModel,
    val title: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    val rating: Double,
    val price: Double,
    @SerialName("enrolled")
    val enrolledPeople: Int,
    val description: String,
    val tags: List<String>,
    val lessons: List<LessonModel>
)
