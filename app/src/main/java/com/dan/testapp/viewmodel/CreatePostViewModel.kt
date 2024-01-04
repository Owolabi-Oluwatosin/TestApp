package com.dan.testapp.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.testapp.repository.CreatePostRepository
import com.dan.testapp.viewmodel.state.PostState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

//(context: Context) : ViewModel()

class CreatePostViewModel @Inject constructor(private val createPostRepository: CreatePostRepository): ViewModel() {
    private val _createPostState = MutableStateFlow<PostState>(PostState.Empty)
    val createPostState: StateFlow<PostState> = _createPostState

    fun createPost(content: String, image: String) {
        _createPostState.value = PostState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val createPostResponse = createPostRepository.createPost(content, image)
                _createPostState.value = PostState.Success(createPostResponse)
            } catch (exception: HttpException) {
                _createPostState.value = PostState.Error("No internet connection")
            } catch (exception: IOException) {
                _createPostState.value = PostState.Error("Something went wrong")
            }
        }
    }
}