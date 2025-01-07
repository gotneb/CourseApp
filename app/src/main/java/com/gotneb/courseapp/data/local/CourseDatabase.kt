package com.gotneb.courseapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gotneb.courseapp.domain.dao.CourseBookmarkDao
import com.gotneb.courseapp.domain.model.CourseBookmarkModel

@Database(
    entities = [CourseBookmarkModel::class],
    version = 1
)
abstract class CourseDatabase: RoomDatabase() {

    abstract val dao: CourseBookmarkDao
}