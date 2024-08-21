package ru.icecreamru.chatcompose.features.auth.domain

interface AuthRepository {
    suspend fun sendPhone(phone: String): Result<Boolean>
}