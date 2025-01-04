package com.gotneb.courseapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class InstructorModel(
    val id: Int,
    val name: String,
    val profileUrl: String,
)
