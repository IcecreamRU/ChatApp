package ru.icecreamru.chatcompose.features.register.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.icecreamru.chatcompose.ui.theme.ChatComposeTheme

@Composable
fun RegisterScreen() {
    Box {
        Text(
            text = "Регистрация в разработке", modifier = Modifier
                .align(Alignment.Center)
        )

    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 600)
@Composable
fun RegisterScreenPreview() {
    ChatComposeTheme {
        RegisterScreen()
    }
}
