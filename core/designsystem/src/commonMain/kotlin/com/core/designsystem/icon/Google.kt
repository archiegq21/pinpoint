package com.core.designsystem.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Suppress("UnusedReceiverParameter")
val Icons.Google: ImageVector
    get() {
        val current = google
        if (current != null) return current

        return ImageVector.Builder(
            name = "Google",
            defaultWidth = 2443.0.dp,
            defaultHeight = 2500.0.dp,
            viewportWidth = 256.0f,
            viewportHeight = 262.0f,
        ).apply {
            // M255.878 133.451 c0 -10.734 -.871 -18.567 -2.756 -26.69 H130.55 v48.448 h71.947 c-1.45 12.04 -9.283 30.172 -26.69 42.356 l-.244 1.622 38.755 30.023 2.685 .268 c24.659 -22.774 38.875 -56.282 38.875 -96.027
            path(
                fill = SolidColor(Color(0xFF4285F4)),
            ) {
                // M 255.878 133.451
                moveTo(x = 255.878f, y = 133.451f)
                // c 0 -10.734 -0.871 -18.567 -2.756 -26.69
                curveToRelative(
                    dx1 = 0.0f,
                    dy1 = -10.734f,
                    dx2 = -0.871f,
                    dy2 = -18.567f,
                    dx3 = -2.756f,
                    dy3 = -26.69f,
                )
                // H 130.55
                horizontalLineTo(x = 130.55f)
                // v 48.448
                verticalLineToRelative(dy = 48.448f)
                // h 71.947
                horizontalLineToRelative(dx = 71.947f)
                // c -1.45 12.04 -9.283 30.172 -26.69 42.356
                curveToRelative(
                    dx1 = -1.45f,
                    dy1 = 12.04f,
                    dx2 = -9.283f,
                    dy2 = 30.172f,
                    dx3 = -26.69f,
                    dy3 = 42.356f,
                )
                // l -0.244 1.622
                lineToRelative(dx = -0.244f, dy = 1.622f)
                // l 38.755 30.023
                lineToRelative(dx = 38.755f, dy = 30.023f)
                // l 2.685 0.268
                lineToRelative(dx = 2.685f, dy = 0.268f)
                // c 24.659 -22.774 38.875 -56.282 38.875 -96.027
                curveToRelative(
                    dx1 = 24.659f,
                    dy1 = -22.774f,
                    dx2 = 38.875f,
                    dy2 = -56.282f,
                    dx3 = 38.875f,
                    dy3 = -96.027f,
                )
            }
            // M130.55 261.1 c35.248 0 64.839 -11.605 86.453 -31.622 l-41.196 -31.913 c-11.024 7.688 -25.82 13.055 -45.257 13.055 -34.523 0 -63.824 -22.773 -74.269 -54.25 l-1.531 .13 -40.298 31.187 -.527 1.465 C35.393 231.798 79.49 261.1 130.55 261.1
            path(
                fill = SolidColor(Color(0xFF34A853)),
            ) {
                // M 130.55 261.1
                moveTo(x = 130.55f, y = 261.1f)
                // c 35.248 0 64.839 -11.605 86.453 -31.622
                curveToRelative(
                    dx1 = 35.248f,
                    dy1 = 0.0f,
                    dx2 = 64.839f,
                    dy2 = -11.605f,
                    dx3 = 86.453f,
                    dy3 = -31.622f,
                )
                // l -41.196 -31.913
                lineToRelative(dx = -41.196f, dy = -31.913f)
                // c -11.024 7.688 -25.82 13.055 -45.257 13.055
                curveToRelative(
                    dx1 = -11.024f,
                    dy1 = 7.688f,
                    dx2 = -25.82f,
                    dy2 = 13.055f,
                    dx3 = -45.257f,
                    dy3 = 13.055f,
                )
                // c -34.523 0 -63.824 -22.773 -74.269 -54.25
                curveToRelative(
                    dx1 = -34.523f,
                    dy1 = 0.0f,
                    dx2 = -63.824f,
                    dy2 = -22.773f,
                    dx3 = -74.269f,
                    dy3 = -54.25f,
                )
                // l -1.531 0.13
                lineToRelative(dx = -1.531f, dy = 0.13f)
                // l -40.298 31.187
                lineToRelative(dx = -40.298f, dy = 31.187f)
                // l -0.527 1.465
                lineToRelative(dx = -0.527f, dy = 1.465f)
                // C 35.393 231.798 79.49 261.1 130.55 261.1
                curveTo(
                    x1 = 35.393f,
                    y1 = 231.798f,
                    x2 = 79.49f,
                    y2 = 261.1f,
                    x3 = 130.55f,
                    y3 = 261.1f,
                )
            }
            // M56.281 156.37 c-2.756 -8.123 -4.351 -16.827 -4.351 -25.82 0 -8.994 1.595 -17.697 4.206 -25.82 l-.073 -1.73 L15.26 71.312 l-1.335 .635 C5.077 89.644 0 109.517 0 130.55 s5.077 40.905 13.925 58.602 l42.356 -32.782
            path(
                fill = SolidColor(Color(0xFFFBBC05)),
            ) {
                // M 56.281 156.37
                moveTo(x = 56.281f, y = 156.37f)
                // c -2.756 -8.123 -4.351 -16.827 -4.351 -25.82
                curveToRelative(
                    dx1 = -2.756f,
                    dy1 = -8.123f,
                    dx2 = -4.351f,
                    dy2 = -16.827f,
                    dx3 = -4.351f,
                    dy3 = -25.82f,
                )
                // c 0 -8.994 1.595 -17.697 4.206 -25.82
                curveToRelative(
                    dx1 = 0.0f,
                    dy1 = -8.994f,
                    dx2 = 1.595f,
                    dy2 = -17.697f,
                    dx3 = 4.206f,
                    dy3 = -25.82f,
                )
                // l -0.073 -1.73
                lineToRelative(dx = -0.073f, dy = -1.73f)
                // L 15.26 71.312
                lineTo(x = 15.26f, y = 71.312f)
                // l -1.335 0.635
                lineToRelative(dx = -1.335f, dy = 0.635f)
                // C 5.077 89.644 0 109.517 0 130.55
                curveTo(
                    x1 = 5.077f,
                    y1 = 89.644f,
                    x2 = 0.0f,
                    y2 = 109.517f,
                    x3 = 0.0f,
                    y3 = 130.55f,
                )
                // s 5.077 40.905 13.925 58.602
                reflectiveCurveToRelative(
                    dx1 = 5.077f,
                    dy1 = 40.905f,
                    dx2 = 13.925f,
                    dy2 = 58.602f,
                )
                // l 42.356 -32.782
                lineToRelative(dx = 42.356f, dy = -32.782f)
            }
            // M130.55 50.479 c24.514 0 41.05 10.589 50.479 19.438 l36.844 -35.974 C195.245 12.91 165.798 0 130.55 0 79.49 0 35.393 29.301 13.925 71.947 l42.211 32.783 c10.59 -31.477 39.891 -54.251 74.414 -54.251
            path(
                fill = SolidColor(Color(0xFFEB4335)),
            ) {
                // M 130.55 50.479
                moveTo(x = 130.55f, y = 50.479f)
                // c 24.514 0 41.05 10.589 50.479 19.438
                curveToRelative(
                    dx1 = 24.514f,
                    dy1 = 0.0f,
                    dx2 = 41.05f,
                    dy2 = 10.589f,
                    dx3 = 50.479f,
                    dy3 = 19.438f,
                )
                // l 36.844 -35.974
                lineToRelative(dx = 36.844f, dy = -35.974f)
                // C 195.245 12.91 165.798 0 130.55 0
                curveTo(
                    x1 = 195.245f,
                    y1 = 12.91f,
                    x2 = 165.798f,
                    y2 = 0.0f,
                    x3 = 130.55f,
                    y3 = 0.0f,
                )
                // C 79.49 0 35.393 29.301 13.925 71.947
                curveTo(
                    x1 = 79.49f,
                    y1 = 0.0f,
                    x2 = 35.393f,
                    y2 = 29.301f,
                    x3 = 13.925f,
                    y3 = 71.947f,
                )
                // l 42.211 32.783
                lineToRelative(dx = 42.211f, dy = 32.783f)
                // c 10.59 -31.477 39.891 -54.251 74.414 -54.251
                curveToRelative(
                    dx1 = 10.59f,
                    dy1 = -31.477f,
                    dx2 = 39.891f,
                    dy2 = -54.251f,
                    dx3 = 74.414f,
                    dy3 = -54.251f,
                )
            }
        }.build().also { google = it }
    }

private var google: ImageVector? = null

@Preview
@Composable
private fun GoogleIconPreview() {
    Box(Modifier.size(48.dp)) {
        Image(
            imageVector = Icons.Google,
            contentDescription = null,
            modifier = Modifier.matchParentSize()
        )
    }
}