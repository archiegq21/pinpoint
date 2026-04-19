package com.feature.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.core.designsystem.icon.AppIcon
import com.core.designsystem.icon.Google
import com.core.designsystem.icon.Icons
import com.core.designsystem.theme.CandyTheme
import com.feature.auth.sources.rememberGoogleSignInHandler
import com.feature.auth.Res
import com.feature.auth.login
import com.feature.auth.login_email
import com.feature.auth.login_google
import com.feature.auth.login_or
import com.feature.auth.login_password
import com.feature.auth.login_signup
import com.feature.auth.login_subtitle
import com.feature.auth.login_title
import com.feature.auth.password_visibility_hide
import com.feature.auth.password_visibility_show
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginRoute(
    onLoginClick: (String, String) -> Unit,
    onSignUpClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LoginScreen(
        onLoginClick = onLoginClick,
        onSignUpClick = onSignUpClick,
        onGoogleSignInClick = onGoogleSignInClick,
        modifier = modifier
    )
}

@Composable
private fun LoginScreen(
    onLoginClick: (String, String) -> Unit,
    onSignUpClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val googleSignInHandler = rememberGoogleSignInHandler()

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
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        0.0f to MaterialTheme.colorScheme.primary,
                        0.8f to MaterialTheme.colorScheme.tertiary,
                    ),
                    shape = MaterialTheme.shapes.large,
                )
                .size(120.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                imageVector = Icons.AppIcon,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(Res.string.login_title),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(Res.string.login_subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            textStyle = MaterialTheme.typography.bodyMedium,
            label = { Text(stringResource(Res.string.login_email)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            textStyle = MaterialTheme.typography.bodyMedium,
            label = { Text(stringResource(Res.string.login_password)) },
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

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onLoginClick(email, password) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(stringResource(Res.string.login))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(Res.string.login_or),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            HorizontalDivider(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                coroutineScope.launch {
                    try {
                        val credentials = googleSignInHandler.getCredential()
                        onGoogleSignInClick()
                    } catch (e: Exception) {
                        // TODO
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(
                imageVector = Icons.Google,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
            )
            Spacer(Modifier.width(8.dp))
            Text(stringResource(Res.string.login_google))
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onSignUpClick) {
            Text(stringResource(Res.string.login_signup))
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    CandyTheme(
        dynamicColor = false,
    ) {
        LoginScreen(
            onLoginClick = { _, _ -> },
            onSignUpClick = {},
            onGoogleSignInClick = {}
        )
    }
}

@Composable
@Preview(uiMode = AndroidUiModes.UI_MODE_NIGHT_YES)
fun LoginScreenDarkPreview() {
    CandyTheme(
        dynamicColor = false,
    ) {
        LoginScreen(
            onLoginClick = { _, _ -> },
            onSignUpClick = {},
            onGoogleSignInClick = {}
        )
    }
}
