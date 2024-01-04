package com.dan.testapp.repository

import com.dan.testapp.data.remotes.ApiService
import com.dan.testapp.data.remotes.models.userpost.UserPost
import javax.inject.Inject


class CreatePostRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun createPost(
        content:String,
        image: String
    ): UserPost = apiService.createPost(content, image)
}
