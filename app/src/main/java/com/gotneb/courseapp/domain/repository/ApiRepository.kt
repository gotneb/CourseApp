package com.gotneb.courseapp.domain.repository

import com.gotneb.courseapp.domain.model.CourseModel
import com.gotneb.courseapp.domain.model.InstructorModel
import com.gotneb.courseapp.domain.model.SearchCourseResponseModel
import com.skydoves.sandwich.ApiResponse

interface ApiRepository {
    suspend fun getCourse(id: Int): ApiResponse<CourseModel>

    suspend fun getInstructor(id: Int): ApiResponse<InstructorModel>

    suspend fun searchCourse(name: String): ApiResponse<SearchCourseResponseModel>

    suspend fun getPopularCourses(): ApiResponse<SearchCourseResponseModel>

    suspend fun getCoursesByCategory(category: String): ApiResponse<SearchCourseResponseModel>

}