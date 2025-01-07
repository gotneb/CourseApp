package com.gotneb.courseapp.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.gotneb.courseapp.domain.model.CourseBookmarkModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseBookmarkDao {
    @Upsert
    suspend fun upsertCourseBookmark(course: CourseBookmarkModel)

    @Query("DELETE FROM CourseBookmarkModel WHERE courseId = :id")
    suspend fun deleteCourseBookmark(id: Int)

    @Query("SELECT * FROM CourseBookmarkModel WHERE courseId = :id")
    suspend fun getCourseBookmarkById(id: Int): CourseBookmarkModel?

    @Query("SELECT * FROM CourseBookmarkModel")
    suspend fun getAllCourseBookmarks(): List<CourseBookmarkModel>?
}