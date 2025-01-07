package com.gotneb.courseapp.presentation.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gotneb.courseapp.domain.dao.CourseBookmarkDao
import com.gotneb.courseapp.domain.model.CourseBookmarkModel
import com.gotneb.courseapp.domain.repository.ApiRepository
import com.gotneb.courseapp.presentation.screen.bookmark.categories
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
class HomeScreenViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val dao: CourseBookmarkDao,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCategoriesCourses(_state.value.selectedCategory)
            getPopularCourses()

            dao.getAllCourseBookmarks()?.map { course ->
                // 大嫌い 「course.id」
                course.courseId
            }
            ?.forEach { id ->
                updateBookmarkState(id)
            }
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
            it.copy(categoriesCourses = it.categoriesCourses.map { course ->
                if (course.id == id) {
                    course.copy(isBookmarked = !course.isBookmarked!!)
                } else course
            }, popularCourses = it.popularCourses.map { course ->
                if (course.id == id) {
                    course.copy(isBookmarked = !course.isBookmarked!!)
                } else course
            })
        }
    }

    fun onCategoryChange(category: String) {
        _state.update {
            it.copy(
                selectedCategory = category,
                isLoadingCategoriesCourses = true,
            )
        }
        viewModelScope.launch {
            getCategoriesCourses(category)
        }
    }

    fun onQueryChange(query: String) {
        _state.update {
            it.copy(searchText = query)
        }
    }

    suspend fun getCategoriesCourses(category: String) =
        repository.getCoursesByCategory(category).onSuccess {
            Log.d("HomeScreen", "Sucess fetching course category \"${category}\"")
            _state.update {
                it.copy(
                    isLoadingCategoriesCourses = false,
                    categoriesCourses = data.data,
                )
            }
        }.onFailure {
            Log.e(
                "HomeScreen",
                "Error fetching course category \"${category}\"\nError -> ${message()}"
            )
            _state.update {
                it.copy(isLoadingCategoriesCourses = false)
            }
        }.onError {
            Log.e(
                "HomeScreen", "Error fetching course category \"category\"\nError -> ${message()}"
            )
            _state.update {
                it.copy(isLoadingCategoriesCourses = false)
            }
        }

    suspend fun getPopularCourses() = repository.getPopularCourses().onSuccess {
        _state.update {
            it.copy(
                isLoadingPopularCourses = false,
                popularCourses = data.data,
            )
        }
    }.onFailure {
        _state.update {
            it.copy(isLoadingPopularCourses = false)
        }
    }.onError {
        _state.update {
            it.copy(isLoadingPopularCourses = false)
        }
    }
}