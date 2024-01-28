package com.dan.testapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dan.testapp.R
import com.dan.testapp.components.*
import com.dan.testapp.data.remotes.models.usersignup.UserSignUp
import com.dan.testapp.navigation.PostOfficeAppRouter
import com.dan.testapp.navigation.Screen
import com.dan.testapp.navigation.SystemBackButtonHandler
import com.dan.testapp.util.LoadingAnimation
import com.dan.testapp.viewmodel.UserSignUpViewModel
import com.dan.testapp.viewmodel.state.UserSignUpState

@Composable
fun SignUpScreen(userSignUpViewModel: UserSignUpViewModel = viewModel()) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            when (val state = userSignUpViewModel.userSignUpState.collectAsState().value) {
                is UserSignUpState.Empty -> SignUpContent()
                is UserSignUpState.Loading -> LoadingAnimation()
                is UserSignUpState.Success -> {
                    PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
//                    DisposableEffect(userSignUpViewModel) {
//                        onDispose {
//
//                        }
//                    }
                }
                is UserSignUpState.Error -> ErrorCompose(error = state.message)
            }

        }
    }
    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
    }
}

@Composable
fun SignUpContent(userSignUpViewModel: UserSignUpViewModel = viewModel()){
    val firstName = remember {
        mutableStateOf("")
    }
    val lastName = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    val userSignUpRequest = UserSignUp(
        firstName = firstName.value.trim(),
        lastName = lastName.value.trim(),
        email = email.value.trim(),
        password = password.value.trim()
    )

    NormalTextComponent(value = stringResource(id = R.string.hello))
    HeadingNormalTextComponent(value = stringResource(id = R.string.create_account))
    Spacer(modifier = Modifier.height(20.dp))
    MyTextFieldComponent(
        labelValue = stringResource(id = R.string.first_name),
        painterResource = painterResource(id = R.drawable.profile),
        onTextChanged = {
            firstName.value = it
        }
    )
    MyTextFieldComponent(
        labelValue = stringResource(id = R.string.last_name),
        painterResource = painterResource(id = R.drawable.profile),
        onTextChanged = {
            lastName.value = it
        }
    )
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
    CheckboxComponent(
        value = stringResource(id = R.string.terms_and_conditions),
        onTextSelected = {
            PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
        }
    )

    Spacer(modifier = Modifier.height(40.dp))

    ButtonComponent(
        value = stringResource(id = R.string.register),
        onButtonClicked = {
            userSignUpViewModel.userSignUp(userSignUpRequest)
        }
    )

    Spacer(modifier = Modifier.height(20.dp))

    DividerTextComponent()

    ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
        PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
    })
}

@Composable
fun ErrorCompose(error: String){
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NormalTextComponent(value = error)
        Spacer(modifier = Modifier.height(2.dp))
        ReloadComponent(onTextSelected = {
            PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
        })
    }
}