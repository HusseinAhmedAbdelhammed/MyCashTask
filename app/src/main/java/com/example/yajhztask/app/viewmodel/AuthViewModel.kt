package com.example.yajhztask.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yajhztask.app.state.ResponseState
import com.example.yajhztask.domain.models.auth.login.LoginRes
import com.example.yajhztask.domain.models.auth.reg.RegRes
import com.example.yajhztask.domain.models.basecat.BaseCatRespoonse
import com.example.yajhztask.domain.usecases.Login
import com.example.yajhztask.domain.usecases.Register
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AuthViewModel@Inject constructor(private val login:Login, private val reg:Register):ViewModel() {
    var logIn : MutableStateFlow<ResponseState<LoginRes>> = MutableStateFlow(ResponseState.OnLoading(false))
    private val _logIn: StateFlow<ResponseState<LoginRes>> = logIn
    var register : MutableStateFlow<ResponseState<RegRes>> = MutableStateFlow(ResponseState.OnLoading(false))
    private val _register: StateFlow<ResponseState<RegRes>> = register
    fun logIN(email:String,password:String,deviceToken:String){
        viewModelScope.launch{
            login(email,password,deviceToken).flowOn(Dispatchers.IO).catch {
                logIn.emit(ResponseState.OnError(it.message?:"No message found"))
            }.collect{
                logIn.emit(ResponseState.OnSuccess(it))
            }
        }
    }
    fun register(name:String,email: String,
                 password: String,phoneNumber:String,deviceToken:String){
        viewModelScope.launch{
            reg(name,email,password,phoneNumber,deviceToken).flowOn(Dispatchers.IO).catch {
                register.emit(ResponseState.OnError(it.message?:"No message found"))
            }.collect{
                register.emit(ResponseState.OnSuccess(it))
            }
        }
    }
}