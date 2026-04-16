package com.core.designsystem.icon.filled

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.core.designsystem.icon.Icons

@Suppress("UnusedReceiverParameter")
val Icons.Filled.ArrowBack: ImageVector
    get() {
        val current = arrowBack
        if (current != null) return current

        return ImageVector.Builder(
            name = "ArrowBack",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0f,
            viewportHeight = 960.0f,
        ).apply {
            // m313 -440 196 196 q12 12 11.5 28 T508 -188 q-12 11 -28 11.5 T452 -188 L188 -452 q-6 -6 -8.5 -13 t-2.5 -15 q0 -8 2.5 -15 t8.5 -13 l264 -264 q11 -11 27.5 -11 t28.5 11 q12 12 12 28.5 T508 -715 L313 -520 h447 q17 0 28.5 11.5 T800 -480 q0 17 -11.5 28.5 T760 -440 H313Z
            path(
                fill = SolidColor(Color(0xFFE3E3E3)),
            ) {
                // M 313 520
                moveTo(x = 313.0f, y = 520.0f)
                // l 196 196
                lineToRelative(dx = 196.0f, dy = 196.0f)
                // q 12 12 11.5 28
                quadToRelative(
                    dx1 = 12.0f,
                    dy1 = 12.0f,
                    dx2 = 11.5f,
                    dy2 = 28.0f,
                )
                // T 508 772
                reflectiveQuadTo(
                    x1 = 508.0f,
                    y1 = 772.0f,
                )
                // q -12 11 -28 11.5
                quadToRelative(
                    dx1 = -12.0f,
                    dy1 = 11.0f,
                    dx2 = -28.0f,
                    dy2 = 11.5f,
                )
                // T 452 772
                reflectiveQuadTo(
                    x1 = 452.0f,
                    y1 = 772.0f,
                )
                // L 188 508
                lineTo(x = 188.0f, y = 508.0f)
                // q -6 -6 -8.5 -13
                quadToRelative(
                    dx1 = -6.0f,
                    dy1 = -6.0f,
                    dx2 = -8.5f,
                    dy2 = -13.0f,
                )
                // t -2.5 -15
                reflectiveQuadToRelative(
                    dx1 = -2.5f,
                    dy1 = -15.0f,
                )
                // q 0 -8 2.5 -15
                quadToRelative(
                    dx1 = 0.0f,
                    dy1 = -8.0f,
                    dx2 = 2.5f,
                    dy2 = -15.0f,
                )
                // t 8.5 -13
                reflectiveQuadToRelative(
                    dx1 = 8.5f,
                    dy1 = -13.0f,
                )
                // l 264 -264
                lineToRelative(dx = 264.0f, dy = -264.0f)
                // q 11 -11 27.5 -11
                quadToRelative(
                    dx1 = 11.0f,
                    dy1 = -11.0f,
                    dx2 = 27.5f,
                    dy2 = -11.0f,
                )
                // t 28.5 11
                reflectiveQuadToRelative(
                    dx1 = 28.5f,
                    dy1 = 11.0f,
                )
                // q 12 12 12 28.5
                quadToRelative(
                    dx1 = 12.0f,
                    dy1 = 12.0f,
                    dx2 = 12.0f,
                    dy2 = 28.5f,
                )
                // T 508 245
                reflectiveQuadTo(
                    x1 = 508.0f,
                    y1 = 245.0f,
                )
                // L 313 440
                lineTo(x = 313.0f, y = 440.0f)
                // l 447 0
                lineToRelative(dx = 447.0f, dy = 0.0f)
                // q 17 0 28.5 11.5
                quadToRelative(
                    dx1 = 17.0f,
                    dy1 = 0.0f,
                    dx2 = 28.5f,
                    dy2 = 11.5f,
                )
                // T 800 480
                reflectiveQuadTo(
                    x1 = 800.0f,
                    y1 = 480.0f,
                )
                // q 0 17 -11.5 28.5
                quadToRelative(
                    dx1 = 0.0f,
                    dy1 = 17.0f,
                    dx2 = -11.5f,
                    dy2 = 28.5f,
                )
                // T 760 520
                reflectiveQuadTo(
                    x1 = 760.0f,
                    y1 = 520.0f,
                )
                // L 313 520z
                lineTo(x = 313.0f, y = 520.0f)
                close()
            }
        }.build().also { arrowBack = it }
    }

private var arrowBack: ImageVector? = null

@Preview
@Composable
private fun ArrowBackIconPreview() {
    Box(Modifier.size(48.dp)) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier.matchParentSize()
        )
    }
}