package ru.icecreamru.chatcompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.icecreamru.chatcompose.navigation.ChatNavHost

@Composable
fun ChatApp(appState: ChatAppState) {
    Scaffold { paddingValues ->
        ChatNavHost(appState = appState, modifier = Modifier.padding(paddingValues))
    }
}