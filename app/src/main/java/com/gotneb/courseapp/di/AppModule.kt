package com.gotneb.courseapp.di

import android.content.Context
import androidx.room.Room
import com.gotneb.courseapp.data.local.CourseDatabase
import com.gotneb.courseapp.data.repository.API
import com.gotneb.courseapp.data.repository.ApiRepositoryImpl
import com.gotneb.courseapp.domain.dao.CourseBookmarkDao
import com.gotneb.courseapp.domain.repository.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(OkHttp.create()) {
        defaultRequest {
            url(API.BASE_URL)
            header(HttpHeaders.ContentType, "application/json")
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    @Provides
    @Singleton
    fun provideApiRepository(httpClient: HttpClient): ApiRepository = ApiRepositoryImpl(httpClient)

    @Provides
    @Singleton
    fun provideCourseDatabase(@ApplicationContext context: Context): CourseDatabase {
        return Room.databaseBuilder(
            context,
            CourseDatabase::class.java,
            "course_db",
        ).build()
    }

    @Provides
    @Singleton
    fun provideCourseBookmarkDao(db: CourseDatabase): CourseBookmarkDao = db.dao
}