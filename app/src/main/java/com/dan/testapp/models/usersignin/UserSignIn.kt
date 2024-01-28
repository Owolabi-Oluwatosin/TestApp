package com.dan.testapp.models.usersignin

import kotlinx.serialization.Serializable

@Serializable
data class User(
   val _id: String = "",
   val firstName: String = "",
   val lastName: String = "",
   val handle: String = "",
   val email: String = "",
   val role: String = ""
)

//data class Token(
//    val access_token: String?,
//)

//data class UserSignIn(
//    val user: User,
//    val access_token: Token
//)
