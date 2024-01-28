package com.dan.testapp.models.usersignin

import kotlinx.serialization.Serializable

@Serializable
data class UserSignInRequest(
    val email: String = "",
    val password: String =""
)
