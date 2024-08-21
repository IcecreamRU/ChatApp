package ru.icecreamru.chatcompose.features.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.icecreamru.chatcompose.features.auth.domain.SendPhoneUseCase
import javax.inject.Inject

@HiltViewModel
class AuthVIewModel @Inject constructor(private val sendPhoneUseCase: SendPhoneUseCase) :
    ViewModel() {
    fun testServerRequest(phone: String) {
        viewModelScope.launch {
            sendPhoneUseCase(phone)
        }
    }
}