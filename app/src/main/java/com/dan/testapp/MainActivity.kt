package com.dan.testapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dan.testapp.navigation.PostOfficeAppRouter
import com.dan.testapp.navigation.Screen
import com.dan.testapp.screens.HomeScreen
import com.dan.testapp.screens.LoginScreen
import com.dan.testapp.screens.SignUpScreen
import com.dan.testapp.screens.TermsAndConditionsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.colorPrimary)
        setContent {
            PostOfficeApp()
        }
    }
}


