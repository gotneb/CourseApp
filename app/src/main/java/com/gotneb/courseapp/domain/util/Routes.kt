package com.gotneb.courseapp.domain.util

import kotlinx.serialization.Serializable

interface Route {
    val name: String
}

@Serializable
data object HomeScreen : Route {
    override val name = "home"
}

@Serializable
data object BookmarkScreen : Route {
    override val name = "bookmarks"
}

@Serializable
data object SearchScreen : Route {
    override val name = "search"
}

@Serializable
data object MyCoursesScreen : Route {
    override val name = "my_courses"
}

@Serializable
data class CourseDetail(
    val id: Int
) : Route {
    override val name = "course_detail"
}