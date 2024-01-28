package com.dan.testapp.data.remotes.models.usersignin

import kotlinx.serialization.Serializable

@Serializable
data class UserSignInResponse(
    val user: User,
    val access_token: String,
)
