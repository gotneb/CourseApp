package com.gotneb.courseapp.presentation.screen.search

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.gotneb.courseapp.domain.repository.ApiRepository
import com.gotneb.courseapp.domain.util.SearchScreen
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
class SearchScreenViewModel @Inject constructor(
    private val repository: ApiRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(SearchScreenState())
    val state = _state.asStateFlow()

    init {
        val args = savedStateHandle.toRoute<SearchScreen>()

        _state.update {
            it.copy(searchText = args.searchText)
        }

        viewModelScope.launch {
            searchCourse(args.searchText)
        }
    }

    fun onQueryChange(text: String) {
        _state.update {
            it.copy(searchText = text)
        }
    }

    fun onSearchClick() {
        _state.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            searchCourse(_state.value.searchText)
        }
    }

    suspend fun searchCourse(query: String) = repository
        .searchCourse(query)
        .onSuccess {
            Log.d("SearchScreen", "Sucess searching for ${query}")
            _state.update {
                it.copy(
                    isLoading = false,
                    courses = data.data
                )
            }
        }.onFailure {
            _state.update {
                Log.e("SearchScreen", "Error searching for ${query}\nError -> ${message()}")
                it.copy(isLoading = false)
            }
        }.onError {
            Log.e("SearchScreen", "Error searching for ${query}\nError -> ${message()}")
            _state.update {
                it.copy(isLoading = false)
            }
        }
}