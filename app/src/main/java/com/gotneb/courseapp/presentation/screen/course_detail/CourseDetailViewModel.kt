package com.gotneb.courseapp.presentation.screen.course_detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.gotneb.courseapp.domain.repository.ApiRepository
import com.gotneb.courseapp.domain.util.CourseDetailScreen
import com.gotneb.courseapp.domain.util.SearchScreen
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
class CourseDetailViewModel @Inject constructor(
    val repository: ApiRepository,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val _state = MutableStateFlow(CourseDetailState())
    val state = _state.asStateFlow()

    init {
        val args = savedStateHandle.toRoute<CourseDetailScreen>()

        viewModelScope.launch {
            getCourse(args.id)
        }
    }

    suspend fun getCourse(id: Int) = repository.getCourse(id)
        .onSuccess {
            Log.d("CourseDetailScreen", "Sucess fetching course id $id")
            _state.update {
                it.copy(
                    isLoading = false,
                    course = data,
                )
            }
        }
        .onFailure {
            Log.e("CourseDetailScreen", "Error fetching course id $id")
            _state.update {
                it.copy(isLoading = false)
            }
        }
        .onError {
            Log.e("CourseDetailScreen", "Error fetching course id $id")
            _state.update {
                it.copy(isLoading = false)
            }
        }
}