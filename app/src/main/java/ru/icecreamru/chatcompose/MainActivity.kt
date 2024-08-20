package ru.icecreamru.chatcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ru.icecreamru.chatcompose.ui.ChatApp
import ru.icecreamru.chatcompose.ui.ChatAppState
import ru.icecreamru.chatcompose.ui.rememberChatAppState
import ru.icecreamru.chatcompose.ui.theme.ChatComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberChatAppState()
            ChatComposeTheme {
                ChatApp(appState = appState)
            }
        }
    }
}