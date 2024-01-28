package com.dan.testapp.data.remotes.models.usersignup

import kotlinx.serialization.Serializable

@Serializable
data class UserSignUpResponse(
    val user: List<UserSignUp>
)
