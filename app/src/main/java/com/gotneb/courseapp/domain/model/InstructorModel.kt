package com.gotneb.courseapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InstructorModel(
    val id: Int,
    val name: String,
    @SerialName("profile_url")
    val profileUrl: String,
)
