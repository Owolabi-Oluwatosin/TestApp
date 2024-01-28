package com.dan.testapp.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.testapp.data.remotes.models.usersignup.UserSignUp
import com.dan.testapp.repository.SignupRepository
import com.dan.testapp.viewmodel.state.UserSignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject


@HiltViewModel
class UserSignUpViewModel @Inject constructor(private val signUpRepository: SignupRepository): ViewModel()  {
    private val _userSignUpState = MutableStateFlow<UserSignUpState>(UserSignUpState.Empty)
    val userSignUpState: StateFlow<UserSignUpState> = _userSignUpState

    fun userSignUp(_userSignUp: UserSignUp) {
        _userSignUpState.value = UserSignUpState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {

                val signUpResponse = signUpRepository.userSignup(_userSignUp)
                _userSignUpState.value = UserSignUpState.Success(signUpResponse)
            }
            catch (exception: HttpException){
                _userSignUpState.value = UserSignUpState.Error("No internet connection")
            }
            catch (exception: IOException){
                _userSignUpState.value = UserSignUpState.Error("Something went wrong")
            }
        }
    }
}