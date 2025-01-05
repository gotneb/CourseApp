package com.gotneb.courseapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LessonModel(
    val id: Int,
    val title: String,
    val duration: Int,
    @SerialName("video_url")
    val videoUrl: String,
)
