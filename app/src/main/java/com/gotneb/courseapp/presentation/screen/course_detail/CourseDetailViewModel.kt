package com.gotneb.courseapp.presentation.screen.course_detail

import androidx.lifecycle.ViewModel
import com.gotneb.courseapp.domain.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CourseDetailViewModel @Inject constructor(
    val repository: ApiRepository
): ViewModel() {

    private val _state = MutableStateFlow(CourseDetailState())
    val state = _state.asStateFlow()

    suspend fun getCourse(id: Int) {
        TODO()
    }
}