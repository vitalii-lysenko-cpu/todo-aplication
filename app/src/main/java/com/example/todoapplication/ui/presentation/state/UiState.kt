package com.example.todoapplication.ui.presentation.state

import com.example.todoapplication.functionality.entities.Post


sealed interface UiState {

    sealed interface Initial : UiState {
        object Loading : Initial
        data class Error(val message: String) : Initial
    }

    data class Data(
        val posts: List<Post>,
    ) : UiState
}
