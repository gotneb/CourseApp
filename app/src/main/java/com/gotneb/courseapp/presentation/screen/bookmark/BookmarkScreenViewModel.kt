package com.gotneb.courseapp.presentation.screen.bookmark

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gotneb.courseapp.domain.dao.CourseBookmarkDao
import com.gotneb.courseapp.domain.model.CourseBookmarkModel
import com.gotneb.courseapp.domain.repository.ApiRepository
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkScreenViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val dao: CourseBookmarkDao,
) : ViewModel() {

    private val _state = MutableStateFlow(BookmarkScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val ids = dao.getAllCourseBookmarks()
            ids?.let {
                getCourses(it.map { course -> course.courseId }.toList())
            }
            _state.update {
                it.copy(
                    filteredCourses = _state.value.courses,
                )
            }
        }
    }

    fun onSearchFilter(search: String) {
        _state.update {
            it.copy(filteredCourses = it.courses.filter { course ->
                course.title.lowercase().contains(search.lowercase())
            })
        }
    }

    fun onSearchTextChange(search: String) = _state.update {
        it.copy(searchText = search)
    }

    fun onCategoryChange(category: String) {
        _state.update {
            val filtered = if (category == "All") it.courses else {
                it.courses.filter { course -> course.tags.contains(category.lowercase()) }
            }
            it.copy(
                filteredCourses = filtered
            )
        }
    }

    suspend fun getCourses(ids: List<Int>) = repository.getCourses(ids).onSuccess {
        Log.d("BookmarkScreen", "Sucess fetching courses ids \"${ids}\"")
        _state.update {
            val courses = data.data.map { course -> course.copy(isBookmarked = true) }.toList()
            it.copy(
                isLoading = false,
                courses = courses,
            )
        }
    }.onFailure {
        Log.e("BookmarkScreen", "Error fetching courses ids \"${ids}\"\nError -> ${message()}")
        _state.update {
            it.copy(isLoading = false)
        }
    }.onError {
        Log.e("BookmarkScreen", "Error fetching courses ids \"${ids}\"\nError -> ${message()}")
        _state.update {
            it.copy(isLoading = false)
        }
    }

    fun bookmarkCourse(id: Int) {
        viewModelScope.launch {
            if (isCourseBookmarked(id)) dao.deleteCourseBookmark(id)
            else dao.upsertCourseBookmark(CourseBookmarkModel(courseId = id))

            updateBookmarkState(id)
        }
    }

    suspend fun isCourseBookmarked(id: Int): Boolean {
        return dao.getCourseBookmarkById(id) != null
    }

    private fun updateBookmarkState(id: Int) {
        _state.update {
            val courses = it.courses.map { course ->
                if (course.id == id) {
                    course.copy(isBookmarked = !course.isBookmarked!!)
                } else course
            }
            it.copy(
                courses = courses,
                filteredCourses = courses
            )
        }
    }
}