package ru.icecreamru.chatcompose.features.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DisplayMode.Companion.Picker
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.arpitkatiyarprojects.countrypicker.models.PickerTextStyles
import ru.icecreamru.chatcompose.ui.components.ToolbarTitle
import ru.icecreamru.chatcompose.ui.theme.ChatComposeTheme
import ru.icecreamru.fakechatcompose.R

@Composable
fun AuthScreen(
    onAuthSuccess: () -> Unit, onRegister: () -> Unit,
    viewModel: AuthVIewModel = hiltViewModel(),
) {
    AuthContent(onRegister = onRegister)
}

@Composable
fun AuthContent(onRegister: () -> Unit) {
    Scaffold(topBar = { ToolbarTitle(stringResource(id = R.string.feature_auth)) }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp))
                    .align(Alignment.Center)
                    .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
            ) {
                PhoneField(onDone = {})
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(stringResource(id = R.string.btn_auth))
                }
            }
            TextButton(
                onClick = { onRegister() },
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(text = stringResource(id = R.string.first_time))
            }

        }
    }

}

@Composable
private fun PhoneField(modifier: Modifier = Modifier, onDone: () -> Unit) {
    TextField(
        value = "Text text",
        onValueChange = {},
        label = { Text("Телефон") },
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    )

    var mobileNumber: String by remember { mutableStateOf("") }

    CountryPickerOutlinedTextField(
        mobileNumber = mobileNumber,
        onMobileNumberChange = { mobileNumber = it },
        onCountrySelected = {},
        onDone = { onDone() },
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun AuthContentPreview() {
    ChatComposeTheme {
        AuthContent(onRegister = {})
    }
}