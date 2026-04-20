package com.feature.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.AndroidUiModes
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.core.designsystem.icon.Icons
import com.core.designsystem.icon.filled.Person
import com.core.designsystem.theme.CandyTheme
import com.feature.profile.Res
import com.feature.profile.profile_image_content_description
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProfileImage(
    profileImageUrl: String?,
    modifier: Modifier = Modifier,
) {
    SubcomposeAsyncImage(
        model = profileImageUrl,
        loading = { CircularProgressIndicator() },
        error = { _ ->
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier
                    .matchParentSize()
                    .padding(12.dp),
            )
        },
        contentDescription = stringResource(Res.string.profile_image_content_description),
        modifier = modifier
            .clip(CircleShape)
            .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
            .background(MaterialTheme.colorScheme.surfaceVariant),
    )
}

@Preview
@Composable
private fun ProfileImagePreview() {
    CandyTheme {
        ProfileImage(
            profileImageUrl = "https://example.com/photo.jpg",
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp)
        )
    }
}

@Preview(uiMode = AndroidUiModes.UI_MODE_NIGHT_YES)
@Composable
private fun ProfileImageDarkPreview() {
    CandyTheme {
        ProfileImage(
            profileImageUrl = "https://example.com/photo.jpg",
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp)
        )
    }
}
