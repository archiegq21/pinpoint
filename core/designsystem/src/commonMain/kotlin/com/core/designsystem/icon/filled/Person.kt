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
val Icons.Filled.Person: ImageVector
    get() {
        val current = person
        if (current != null) return current

        return ImageVector.Builder(
            name = "Person",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0f,
            viewportHeight = 960.0f,
        ).apply {
            // M367 -527 q-47 -47 -47 -113 t47 -113 q47 -47 113 -47 t113 47 q47 47 47 113 t-47 113 q-47 47 -113 47 t-113 -47Z M160 -240 v-32 q0 -34 17.5 -62.5 T224 -378 q62 -31 126 -46.5 T480 -440 q66 0 130 15.5 T736 -378 q29 15 46.5 43.5 T800 -272 v32 q0 33 -23.5 56.5 T720 -160 H240 q-33 0 -56.5 -23.5 T160 -240Z
            path(
                fill = SolidColor(Color(0xFFE3E3E3)),
            ) {
                // M 367 433
                moveTo(x = 367.0f, y = 433.0f)
                // q -47 -47 -47 -113
                quadToRelative(
                    dx1 = -47.0f,
                    dy1 = -47.0f,
                    dx2 = -47.0f,
                    dy2 = -113.0f,
                )
                // t 47 -113
                reflectiveQuadToRelative(
                    dx1 = 47.0f,
                    dy1 = -113.0f,
                )
                // q 47 -47 113 -47
                quadToRelative(
                    dx1 = 47.0f,
                    dy1 = -47.0f,
                    dx2 = 113.0f,
                    dy2 = -47.0f,
                )
                // t 113 47
                reflectiveQuadToRelative(
                    dx1 = 113.0f,
                    dy1 = 47.0f,
                )
                // q 47 47 47 113
                quadToRelative(
                    dx1 = 47.0f,
                    dy1 = 47.0f,
                    dx2 = 47.0f,
                    dy2 = 113.0f,
                )
                // t -47 113
                reflectiveQuadToRelative(
                    dx1 = -47.0f,
                    dy1 = 113.0f,
                )
                // q -47 47 -113 47
                quadToRelative(
                    dx1 = -47.0f,
                    dy1 = 47.0f,
                    dx2 = -113.0f,
                    dy2 = 47.0f,
                )
                // t -113 -47z
                reflectiveQuadToRelative(
                    dx1 = -113.0f,
                    dy1 = -47.0f,
                )
                close()
                // M 160 720
                moveTo(x = 160.0f, y = 720.0f)
                // l 0 -32
                lineToRelative(dx = 0.0f, dy = -32.0f)
                // q 0 -34 17.5 -62.5
                quadToRelative(
                    dx1 = 0.0f,
                    dy1 = -34.0f,
                    dx2 = 17.5f,
                    dy2 = -62.5f,
                )
                // T 224 582
                reflectiveQuadTo(
                    x1 = 224.0f,
                    y1 = 582.0f,
                )
                // q 62 -31 126 -46.5
                quadToRelative(
                    dx1 = 62.0f,
                    dy1 = -31.0f,
                    dx2 = 126.0f,
                    dy2 = -46.5f,
                )
                // T 480 520
                reflectiveQuadTo(
                    x1 = 480.0f,
                    y1 = 520.0f,
                )
                // q 66 0 130 15.5
                quadToRelative(
                    dx1 = 66.0f,
                    dy1 = 0.0f,
                    dx2 = 130.0f,
                    dy2 = 15.5f,
                )
                // T 736 582
                reflectiveQuadTo(
                    x1 = 736.0f,
                    y1 = 582.0f,
                )
                // q 29 15 46.5 43.5
                quadToRelative(
                    dx1 = 29.0f,
                    dy1 = 15.0f,
                    dx2 = 46.5f,
                    dy2 = 43.5f,
                )
                // T 800 688
                reflectiveQuadTo(
                    x1 = 800.0f,
                    y1 = 688.0f,
                )
                // l 0 32
                lineToRelative(dx = 0.0f, dy = 32.0f)
                // q 0 33 -23.5 56.5
                quadToRelative(
                    dx1 = 0.0f,
                    dy1 = 33.0f,
                    dx2 = -23.5f,
                    dy2 = 56.5f,
                )
                // T 720 800
                reflectiveQuadTo(
                    x1 = 720.0f,
                    y1 = 800.0f,
                )
                // L 240 800
                lineTo(x = 240.0f, y = 800.0f)
                // q -33 0 -56.5 -23.5
                quadToRelative(
                    dx1 = -33.0f,
                    dy1 = 0.0f,
                    dx2 = -56.5f,
                    dy2 = -23.5f,
                )
                // T 160 720z
                reflectiveQuadTo(
                    x1 = 160.0f,
                    y1 = 720.0f,
                )
                close()
            }
        }.build().also { person = it }
    }

private var person: ImageVector? = null

@Preview
@Composable
private fun PersonIconPreview() {
    Box(Modifier.size(48.dp)) {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = null,
            modifier = Modifier.matchParentSize()
        )
    }
}