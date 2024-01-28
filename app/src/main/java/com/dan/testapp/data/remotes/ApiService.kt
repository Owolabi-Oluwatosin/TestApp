//package com.dan.testapp.data.remotes
//
//import com.dan.testapp.data.remotes.models.usersignin.UserSignInRequest
//import com.dan.testapp.data.remotes.models.usersignin.UserSignInResponse
//import com.dan.testapp.data.remotes.models.usersignup.UserSignUp
//import com.dan.testapp.data.remotes.models.usersignup.UserSignUpResponse
//import com.dan.testapp.di.client
//import com.dan.testapp.util.BASE_URL
//import com.dan.testapp.util.SIGNIN_ROUTE
//import com.dan.testapp.util.SIGNUP_ROUTE
//import io.ktor.client.call.*
//import io.ktor.client.request.*
//import io.ktor.client.statement.*
//import io.ktor.http.*
//
//interface ApiService {
//
//    suspend fun userSignup(_userSignUp:UserSignUp): UserSignUpResponse {
//        val response: HttpResponse = client.post("$BASE_URL$SIGNUP_ROUTE") {
//            contentType(ContentType.Application.Json)
//            setBody(_userSignUp)
//        }
//        return response.body()
//    }
//
//    suspend fun userSignin(userSignInRequest: UserSignInRequest): UserSignInResponse {
//        val response: HttpResponse = client.post("$BASE_URL$SIGNIN_ROUTE") {
//            contentType(ContentType.Application.Json)
//            setBody(userSignInRequest)
//        }
//        return response.body()
//    }
//
//
//
//}


