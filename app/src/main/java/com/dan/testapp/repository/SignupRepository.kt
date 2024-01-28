package com.dan.testapp.repository

import com.dan.testapp.models.usersignup.UserSignUp
import com.dan.testapp.models.usersignup.UserSignUpResponse
import com.dan.testapp.util.BASE_URL
import com.dan.testapp.util.SIGNUP_ROUTE
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import javax.inject.Inject

class SignupRepository @Inject constructor(private val client: HttpClient){
    suspend fun userSignup(_userSignUp: UserSignUp): UserSignUpResponse {
        val response: HttpResponse = client.post("$BASE_URL$SIGNUP_ROUTE") {
            contentType(ContentType.Application.Json)
            setBody(_userSignUp)
        }
        return response.body()
    }
}