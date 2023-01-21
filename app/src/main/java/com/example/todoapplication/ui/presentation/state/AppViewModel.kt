package com.example.todoapplication.ui.presentation.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplication.functionality.domain.GetPostListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    getPostListUseCase: GetPostListUseCase,
) : ViewModel() {
    private val mutState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Initial.Loading)

    init {
        viewModelScope.launch {
            mutState.emit(
                try {
                    UiState.Data(posts = getPostListUseCase.invoke())
                } catch (e: Exception) {
                    UiState.Initial.Error("Error")
                }
            )
        }
    }

    val state: StateFlow<UiState> = mutState

}