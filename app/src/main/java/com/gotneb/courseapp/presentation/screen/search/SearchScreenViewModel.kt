package com.gotneb.courseapp.presentation.screen.search

import androidx.lifecycle.ViewModel
import com.gotneb.courseapp.domain.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val repository: ApiRepository,
): ViewModel() {

    private val _state = MutableStateFlow(SearchScreenState())
    val state = _state.asStateFlow()

    fun onSearchTextChange(text: String) {
        _state.update {
            it.copy(searchText = text)
        }
    }
}