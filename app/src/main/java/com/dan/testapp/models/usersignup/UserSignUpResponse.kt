package com.dan.testapp.models.usersignup

import kotlinx.serialization.Serializable

@Serializable
data class UserSignUpResponse(
    val user: List<UserSignUp>
)
