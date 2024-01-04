package com.dan.testapp.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.testapp.repository.GetPostRepository
import com.dan.testapp.viewmodel.state.PostState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

//(context: Context) : ViewModel()

class GetPostViewModel @Inject constructor(private val getPostRepository: GetPostRepository): ViewModel() {
    private val _getPostState = MutableStateFlow<PostState>(PostState.Empty)
    val getPostState: StateFlow<PostState> = _getPostState

    private fun getPost() {
        _getPostState.value = PostState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val postResponse = getPostRepository.getPost()
                _getPostState.value = PostState.Success(postResponse)
            } catch (exception: HttpException) {
                _getPostState.value = PostState.Error("No internet connection")
            } catch (exception: IOException) {
                _getPostState.value = PostState.Error("Something went wrong")
            }
        }
    }
}
