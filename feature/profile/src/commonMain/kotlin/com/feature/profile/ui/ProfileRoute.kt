package com.feature.profile.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.AndroidUiModes
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.designsystem.theme.CandyTheme
import com.feature.profile.Res
import com.feature.profile.component.ProfileImage
import com.feature.profile.logout
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProfileRoute(
    onSignOutClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ProfileScreen(
        name = "John Doe",
        email = "john.doe@example.com",
        profileImageUrl = null,
        onSignOutClick = onSignOutClick,
        modifier = modifier
    )
}

@Composable
private fun ProfileScreen(
    name: String,
    email: String,
    profileImageUrl: String?,
    onSignOutClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        ProfileImage(
            profileImageUrl = profileImageUrl,
            modifier = Modifier.size(120.dp),
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = email,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.weight(1f))

        TextButton(
            onClick = onSignOutClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(Res.string.logout))
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    CandyTheme {
        ProfileScreen(
            name = "Jane Smith",
            email = "jane.smith@example.com",
            profileImageUrl = null,
            onSignOutClick = {}
        )
    }
}

@Preview(uiMode = AndroidUiModes.UI_MODE_NIGHT_YES)
@Composable
private fun ProfileScreenDarkPreview() {
    CandyTheme {
        ProfileScreen(
            name = "Jane Smith",
            email = "jane.smith@example.com",
            profileImageUrl = null,
            onSignOutClick = {}
        )
    }
}
