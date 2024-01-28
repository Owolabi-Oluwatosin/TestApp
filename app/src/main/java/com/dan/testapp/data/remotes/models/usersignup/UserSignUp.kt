package com.dan.testapp.data.remotes.models.usersignup

import kotlinx.serialization.Serializable

@Serializable
data class UserSignUp(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = ""
)
