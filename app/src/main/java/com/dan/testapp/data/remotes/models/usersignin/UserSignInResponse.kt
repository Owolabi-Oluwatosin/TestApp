package com.dan.testapp.data.remotes.models.usersignin

data class UserSignInResponse(
    val user: User,
    val access_token: String,
)
