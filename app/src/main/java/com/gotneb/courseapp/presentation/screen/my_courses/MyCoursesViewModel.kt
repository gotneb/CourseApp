package com.gotneb.courseapp.presentation.screen.my_courses

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MyCoursesViewModel @Inject constructor(
    // TODO: add Room dependency
): ViewModel() {

    private val _state = MutableStateFlow(MyCoursesState())
    val state = _state.asStateFlow()

    fun onSearchTextChange(text: String) {
        _state.update {
            it.copy(searchText = text)
        }
    }

}