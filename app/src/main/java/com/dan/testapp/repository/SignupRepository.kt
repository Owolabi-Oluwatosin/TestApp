package com.dan.testapp.repository

import com.dan.testapp.data.remotes.ApiService
import com.dan.testapp.data.remotes.models.usersignup.UserSignUp
import com.dan.testapp.data.remotes.models.usersignup.UserSignUpResponse
import javax.inject.Inject

class SignupRepository @Inject constructor(private val apiService: ApiService){
    suspend fun userSignUp(_userSignUp: UserSignUp): UserSignUpResponse = apiService.userSignup(_userSignUp)
}