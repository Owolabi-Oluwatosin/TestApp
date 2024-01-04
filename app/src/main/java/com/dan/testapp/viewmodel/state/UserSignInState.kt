package com.dan.testapp.viewmodel.state

import com.dan.testapp.data.remotes.models.usersignin.UserSignInResponse

sealed class UserSignInState {
    object Empty: UserSignInState()
    object Loading: UserSignInState()
    class Success(val result: UserSignInResponse): UserSignInState()
    class Error(val message: String): UserSignInState()
}
