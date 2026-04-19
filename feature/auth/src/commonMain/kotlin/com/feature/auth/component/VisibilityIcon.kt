package com.feature.auth.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.feature.auth.Res
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter


@Composable
internal fun VisibilityIcon(
    visible: Boolean,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
) {
    val progress = animateFloatAsState(if (visible) 1f else 0f)

    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/visibility_on_off_icon.json").decodeToString()
        )
    }

    Icon(
        painter = rememberLottiePainter(
            composition = composition,
            progress = { progress.value },
        ),
        contentDescription = contentDescription,
        tint = tint,
        modifier = modifier,
    )
}