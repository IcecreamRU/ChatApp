package ru.icecreamru.chatcompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.util.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kotlinx.coroutines.CoroutineScope
import ru.icecreamru.chatcompose.features.auth.navigation.AUTH_ROUTE
import ru.icecreamru.chatcompose.features.auth.navigation.navigateToAuth
import ru.icecreamru.chatcompose.features.register.navigation.navigateToRegister
import ru.icecreamru.chatcompose.navigation.TopLevelDestination

@Composable
fun rememberChatAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): ChatAppState {
    return remember(
        navController, coroutineScope
    ) {
        ChatAppState(navController, coroutineScope)
    }
}

class ChatAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            AUTH_ROUTE -> TopLevelDestination.AUTH
            else -> null
        }

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

            when (topLevelDestination) {
                TopLevelDestination.AUTH -> navController.navigateToAuth(topLevelNavOptions)
                TopLevelDestination.REGISTER -> navController.navigateToRegister(topLevelNavOptions)
                TopLevelDestination.CHAT -> TODO()
                TopLevelDestination.PROFILE -> TODO()
            }
        }
    }
}