package com.gotneb.courseapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CourseBookmarkModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val courseId: Int,
)
