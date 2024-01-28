package com.dan.testapp.models.usersignup

import kotlinx.serialization.Serializable

@Serializable
data class UserSignUp(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = ""
)
