package com.dan.testapp.repository

import com.dan.testapp.data.remotes.ApiService
import com.dan.testapp.data.remotes.models.usersignin.UserSignInRequest
import com.dan.testapp.data.remotes.models.usersignin.UserSignInResponse
import javax.inject.Inject


class SignInRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun userSignIn(_userSignInRequest: UserSignInRequest): UserSignInResponse = apiService.userSignin(_userSignInRequest)
}
