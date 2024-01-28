package com.dan.testapp.viewmodel.state

import com.dan.testapp.models.userpost.UserPost

sealed class PostState {
    object Empty: PostState()
    object Loading: PostState()
    class Success(val result: UserPost): PostState()
    class Error(val message: String): PostState()
}
