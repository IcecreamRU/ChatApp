package ru.icecreamru.chatcompose.features.auth.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import ru.icecreamru.chatcompose.features.auth.data.model.AuthSendCodeResponseDto

interface AuthApi {
    @POST("/users/send-auth-code/")
    suspend fun sendAuthCode(phone: String): Response<AuthSendCodeResponseDto>

}