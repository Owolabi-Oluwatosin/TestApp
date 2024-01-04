package com.dan.testapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dan.testapp.components.TopNavBar
import com.dan.testapp.data.remotes.models.usersignin.UserSignInResponse
import com.dan.testapp.util.LoadingAnimation
import com.dan.testapp.viewmodel.UserSignInViewModel
import com.dan.testapp.viewmodel.state.UserSignInState

@Composable
fun HomeScreen(userSignInViewModel: UserSignInViewModel = viewModel()) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            when (val state = userSignInViewModel.userSignInState.collectAsState().value) {
                is UserSignInState.Empty -> Text(text = "No data available")
                is UserSignInState.Loading -> LoadingAnimation()
                is UserSignInState.Success -> HomeContent(content = state.result)
                is UserSignInState.Error -> ErrorCompose(error = state.message)
            }
        }
    }
}


@Composable
fun HomeContent(content: UserSignInResponse){
    TopNavBar(content)
}