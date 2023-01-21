package com.example.todoapplication.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoapplication.functionality.entities.Post
import com.example.todoapplication.functionality.entities.PostId
import com.example.todoapplication.functionality.entities.UserId
import com.example.todoapplication.ui.presentation.state.AppViewModel
import com.example.todoapplication.ui.presentation.state.UiState
import com.example.todoapplication.ui.theme.Shapes
import com.example.todoapplication.ui.theme.Teal200

@Composable
fun App(
    appViewModel: AppViewModel = hiltViewModel(),
) {
    val state by appViewModel.state.collectAsState()
    App(
        state = state,
    )
}

@Composable
fun App(
    state: UiState,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is UiState.Initial.Loading -> CircularProgressIndicator(
                color = Color.Blue,

            )
            is UiState.Initial.Error ->
                DialogError(state)
            is UiState.Data -> {
                ShowData(state)
            }
        }
    }
}

@Composable
private fun DialogError(state: UiState.Initial.Error) {
    Card(
        shape = Shapes.medium,
        backgroundColor = Teal200,
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    top = 32.dp,
                    end = 24.dp,
                    bottom = 40.dp
                )
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = state.message,
                textAlign = TextAlign.Center,
                style = typography.h3,
                color = Color.Red
            )
        }
    }
}

@Composable
private fun ShowData(state: UiState.Data) {
    Column {
        Text(text = "hello")

        LazyColumn {
            items(items = state.posts) {
                Column {
                    Text(text = it.postId.value.toString())
                    Text(text = it.title)
                    Text(text = it.userId.value.toString())
                    Text(text = it.completed.toString())
                }
            }
        }
    }
}

@Preview
@Composable
internal fun AppPreview(

) {
    App(
        state = UiState.Data(
            listOf(
                Post(
                    completed = true,
                    postId = PostId(1L),
                    title = "title1",
                    userId = UserId(1L)
                )
            )
        )
    )
}