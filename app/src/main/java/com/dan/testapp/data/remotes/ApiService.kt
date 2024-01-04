package com.dan.testapp.data.remotes

import com.dan.testapp.data.remotes.models.userpost.UserPost
import com.dan.testapp.data.remotes.models.usersignin.UserSignInRequest
import com.dan.testapp.data.remotes.models.usersignin.UserSignInResponse
import com.dan.testapp.data.remotes.models.usersignup.UserSignUp
import com.dan.testapp.data.remotes.models.usersignup.UserSignUpResponse
import retrofit2.http.*

interface ApiService {

    //User API Service
    @GET("/users/{id}")
    suspend fun getUser(@Path("id") postId: Int): UserSignUp

    @POST("/api/auth/signup")
    suspend fun userSignup(@Body _userSignUp:UserSignUp): UserSignUpResponse

    @POST("/api/auth/signin")
    suspend fun userSignin(@Body _userSignIn: UserSignInRequest): UserSignInResponse

    @FormUrlEncoded
    @PUT("/users/{id}")
    suspend fun updateUser(@Path("id") userId: Int, @Body user: UserSignUp): UserSignUp

    @FormUrlEncoded
    @PATCH("/users/{id}")
    suspend fun patchUser(@Path("id") userId: Int, @Body user: UserSignUp): UserSignUp

    @DELETE("/users/{id}")
    suspend fun deleteUser(@Path("id") userId: Int)

    //Post API Service
    @GET("/api/posts")
    suspend fun getPost(): UserPost

    @FormUrlEncoded
    @POST("/api/posts/create")
    suspend fun createPost(
        @Field("content") content: String,
        @Field("image") image: String,
    ): UserPost

    @FormUrlEncoded
    @PUT("/posts/{id}")
    suspend fun updatePost(@Path("id") postId: Int, @Body post: UserPost): UserPost

    @FormUrlEncoded
    @PATCH("/posts/{id}")
    suspend fun patchPost(@Path("id") postId: Int, @Body post: UserPost): UserPost

    @DELETE("/posts/{id}")
    suspend fun deletePost(@Path("id") postId: Int)

}


