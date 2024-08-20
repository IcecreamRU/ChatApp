package ru.icecreamru.chatcompose.features.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import ru.icecreamru.chatcompose.features.auth.presentation.AuthScreen

const val AUTH_ROUTE = "auth_route"

fun NavController.navigateToAuth(navOptions: NavOptions) = navigate(AUTH_ROUTE, navOptions)

fun NavGraphBuilder.authScreen(
    onAuthSuccess: () -> Unit,
    onRegister: () -> Unit
) {
    composable(route = AUTH_ROUTE) {
        AuthScreen(onAuthSuccess, onRegister)
    }
}

