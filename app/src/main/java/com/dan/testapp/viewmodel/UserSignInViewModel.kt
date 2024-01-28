package com.dan.testapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.dan.testapp.models.usersignin.UserSignInRequest
import com.dan.testapp.repository.SignInRepository
import com.dan.testapp.viewmodel.state.UserSignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject


@HiltViewModel
class UserSignInViewModel @Inject constructor(private val signInRepository: SignInRepository): ViewModel()  {
    private val _userSignInState = MutableStateFlow<UserSignInState>(UserSignInState.Empty)
    val userSignInState: StateFlow<UserSignInState> = _userSignInState

    fun userSigning(_userSignIn: UserSignInRequest) {
        _userSignInState.value = UserSignInState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val signInResponse = signInRepository.userSignin(_userSignIn)
                _userSignInState.value = UserSignInState.Success(signInResponse)
//                val signInResponse = signInRepository.userSignIn(_userSignIn)
//                _userSignInState.value = UserSignInState.Success(signInResponse)
            }
            catch (exception: HttpException){
                _userSignInState.value = UserSignInState.Error("No internet connection")
            }
            catch (exception: IOException){
                _userSignInState.value = UserSignInState.Error("Something went wrong")
            }
        }
    }
}