package ru.icecreamru.chatcompose.features.register.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import ru.icecreamru.chatcompose.features.register.presentation.RegisterScreen

const val REGISTER_PATH = "register_path"

fun NavController.navigateToRegister(navOptions: NavOptions? = null) = navigate(REGISTER_PATH, navOptions)

fun NavGraphBuilder.registerScreen() {
    composable(route = REGISTER_PATH) {
        RegisterScreen()
    }
}