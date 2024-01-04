package com.dan.testapp.repository

import com.dan.testapp.data.remotes.ApiService
import com.dan.testapp.data.remotes.models.userpost.UserPost
import javax.inject.Inject


class GetPostRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPost() = apiService.getPost()
}
