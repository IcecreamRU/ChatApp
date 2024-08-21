package ru.icecreamru.chatcompose.features.auth.domain

import com.arpitkatiyarprojects.countrypicker.utils.CountryPickerUtils
import javax.inject.Inject

class SendPhoneUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(phone: String): Result<Boolean> {
        if (CountryPickerUtils.isMobileNumberValid(phone)) {
            return repository.sendPhone(phone)
        } else {
            throw Exception("Номер некорректен")
        }
    }
}