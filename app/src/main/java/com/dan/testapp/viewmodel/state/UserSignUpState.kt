package com.dan.testapp.viewmodel.state

import com.dan.testapp.data.remotes.models.usersignup.UserSignUpResponse

sealed class UserSignUpState {
    object Empty: UserSignUpState()
    object Loading: UserSignUpState()
    class Success(val result: UserSignUpResponse): UserSignUpState()
    class Error(val message: String): UserSignUpState()
}
