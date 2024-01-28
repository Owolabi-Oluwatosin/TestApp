package com.dan.testapp.data.remotes.models.usersignin

import kotlinx.serialization.Serializable

@Serializable
data class UserSignInRequest(
    val email: String = "",
    val password: String =""
)
