package com.dan.testapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dan.testapp.R
import com.dan.testapp.components.HeadingNormalTextComponent
import com.dan.testapp.navigation.PostOfficeAppRouter
import com.dan.testapp.navigation.Screen
import com.dan.testapp.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {

        HeadingNormalTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
    }

    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}