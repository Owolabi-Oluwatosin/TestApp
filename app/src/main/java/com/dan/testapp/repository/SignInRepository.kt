package com.dan.testapp.repository

import com.dan.testapp.models.usersignin.UserSignInRequest
import com.dan.testapp.models.usersignin.UserSignInResponse
import com.dan.testapp.util.BASE_URL
import com.dan.testapp.util.SIGNIN_ROUTE
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject

class SignInRepository @Inject constructor(private val client: HttpClient) {
    suspend fun userSignin(userSignInRequest: UserSignInRequest): UserSignInResponse {
        return client.post("$BASE_URL$SIGNIN_ROUTE") {
            contentType(ContentType.Application.Json)
            setBody(userSignInRequest)
        }.body()
    }
}

