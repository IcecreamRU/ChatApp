package ru.icecreamru.chatcompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.icecreamru.chatcompose.ui.theme.ChatComposeTheme

@Composable
fun ToolbarTitle(title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(56.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
    }
}


@Preview(showBackground = true)
@Composable
fun ToolbarTitlePreview() {
    ChatComposeTheme {
        ToolbarTitle("Toolbar title")
    }
}