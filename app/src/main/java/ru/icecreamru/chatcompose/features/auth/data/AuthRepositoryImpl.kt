package ru.icecreamru.chatcompose.features.auth.data

import ru.icecreamru.chatcompose.features.auth.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authApi: AuthApi) : AuthRepository {
    override suspend fun sendPhone(phone: String): Result<Boolean> {
        // TODO: переделать обработчик ошибок
        val body = authApi.sendAuthCode(phone).body()
        if (body != null) {
            return Result.success(body.is_success)
        } else {
            return Result.failure(Exception("Сервер вернул не то, что нужно"))
        }

    }
}