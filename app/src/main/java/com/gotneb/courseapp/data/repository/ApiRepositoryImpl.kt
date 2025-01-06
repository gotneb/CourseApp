package com.gotneb.courseapp.data.repository

import com.gotneb.courseapp.domain.model.CourseModel
import com.gotneb.courseapp.domain.model.InstructorModel
import com.gotneb.courseapp.domain.model.SearchCourseResponseModel
import com.gotneb.courseapp.domain.repository.ApiRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient

object API {
    const val BASE_URL = "https://course-app-api-daua.onrender.com"
}

class ApiRepositoryImpl(
    private val httpClient: HttpClient
): ApiRepository {
    override suspend fun getCourse(id: Int): ApiResponse<CourseModel> =
        httpClient.getApiResponse("courses/$id")

    override suspend fun getInstructor(id: Int): ApiResponse<InstructorModel> =
        httpClient.getApiResponse("instructors/$id")

    override suspend fun searchCourse(name: String): ApiResponse<SearchCourseResponseModel> =
        httpClient.getApiResponse("search/courses/$name")

    override suspend fun getPopularCourses(): ApiResponse<SearchCourseResponseModel> =
        httpClient.getApiResponse("search/popular")

    override suspend fun getCoursesByCategory(category: String): ApiResponse<SearchCourseResponseModel> =
        httpClient.getApiResponse("search/tags/$category")

}