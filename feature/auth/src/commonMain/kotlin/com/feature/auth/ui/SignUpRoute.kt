package com.feature.auth.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.AndroidUiModes
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.feature.auth.component.VisibilityIcon
import com.core.designsystem.theme.CandyTheme
import com.feature.auth.Res
import com.feature.auth.password_visibility_hide
import com.feature.auth.password_visibility_show
import com.feature.auth.signup
import com.feature.auth.signup_confirm_password
import com.feature.auth.signup_email
import com.feature.auth.signup_login
import com.feature.auth.signup_password
import com.feature.auth.signup_subtitle
import com.feature.auth.signup_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignUpRoute(
    onSignUpClick: (String, String, String) -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SignUpScreen(
        onSignUpClick = onSignUpClick,
        onLoginClick = onLoginClick,
        modifier = modifier
    )
}

@Composable
private fun SignUpScreen(
    onSignUpClick: (String, String, String) -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    0.9f to Color.Transparent,
                    1.0f to MaterialTheme.colorScheme.tertiary,
                )
            )
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
            .padding(bottom = 32.dp, top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(Res.string.signup_title),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(Res.string.signup_subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            textStyle = MaterialTheme.typography.bodyMedium,
            label = { Text(stringResource(Res.string.signup_email)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            textStyle = MaterialTheme.typography.bodyMedium,
            label = { Text(stringResource(Res.string.signup_password)) },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    val contentDescription = if (passwordVisible)
                        stringResource(Res.string.password_visibility_hide)
                    else
                        stringResource(Res.string.password_visibility_show)

                    VisibilityIcon(
                        visible = passwordVisible,
                        contentDescription = contentDescription,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            textStyle = MaterialTheme.typography.bodyMedium,
            label = { Text(stringResource(Res.string.signup_confirm_password)) },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                    val contentDescription = if (confirmPasswordVisible)
                        stringResource(Res.string.password_visibility_hide)
                    else
                        stringResource(Res.string.password_visibility_show)

                    VisibilityIcon(
                        visible = confirmPasswordVisible,
                        contentDescription = contentDescription,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onSignUpClick(name, email, password) },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(stringResource(Res.string.signup))
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onLoginClick) {
            Text(stringResource(Res.string.signup_login))
        }
    }
}

@Composable
@Preview
fun SignUpScreenPreview() {
    CandyTheme(
        dynamicColor = false,
    ) {
        SignUpScreen(
            onSignUpClick = { _, _, _ -> },
            onLoginClick = {},
        )
    }
}

@Composable
@Preview(uiMode = AndroidUiModes.UI_MODE_NIGHT_YES)
fun SignUpScreenDarkPreview() {
    CandyTheme(
        dynamicColor = false,
    ) {
        SignUpScreen(
            onSignUpClick = { _, _, _ -> },
            onLoginClick = {},
        )
    }
}
