package com.dan.testapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dan.testapp.R
import com.dan.testapp.components.*
import com.dan.testapp.data.remotes.models.usersignin.UserSignInRequest
import com.dan.testapp.navigation.PostOfficeAppRouter
import com.dan.testapp.navigation.Screen
import com.dan.testapp.navigation.SystemBackButtonHandler
import com.dan.testapp.util.LoadingAnimation
import com.dan.testapp.viewmodel.UserSignInViewModel
import com.dan.testapp.viewmodel.state.UserSignInState

@Composable
fun LoginScreen(userSignInViewModel: UserSignInViewModel = viewModel()) {

    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            when (val state = userSignInViewModel.userSignInState.collectAsState().value) {
                is UserSignInState.Empty -> SignInContent()
                is UserSignInState.Loading -> LoadingAnimation()
                is UserSignInState.Success -> PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                is UserSignInState.Error -> ErrorCompose(error = state.message)
            }
        }
    }
    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Composable
fun SignInContent(userSignInViewModel: UserSignInViewModel = viewModel()){
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    val userSignInRequest = UserSignInRequest(
        email = email.value.trim(),
        password = password.value.trim()
    )

    NormalTextComponent(value = stringResource(id = R.string.hello))

    HeadingNormalTextComponent(
        value = stringResource(id = R.string.welcome)
    )

    Spacer(modifier = Modifier.height(20.dp))

    MyTextFieldComponent(
        labelValue = stringResource(id = R.string.email),
        painterResource = painterResource(id = R.drawable.message),
        onTextChanged = {
            email.value = it
        }
    )

    PasswordTextFieldComponent(
        labelValue = stringResource(id = R.string.password),
        painterResource = painterResource(id = R.drawable.lock),
        onTextSelected = {
            password.value = it
        }
    )

    Spacer(modifier = Modifier.height(40.dp))

    ButtonComponent(
        value = stringResource(id = R.string.login),
        onButtonClicked = {
            userSignInViewModel.userSigning(userSignInRequest)
        }
    )

    Spacer(modifier = Modifier.height(20.dp))

    DividerTextComponent()

    ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    })
}