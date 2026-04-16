package com.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.core.designsystem.Res
import com.core.designsystem.lora_bold
import com.core.designsystem.lora_bold_italic
import com.core.designsystem.lora_italic
import com.core.designsystem.lora_medium
import com.core.designsystem.lora_medium_italic
import com.core.designsystem.lora_regular
import com.core.designsystem.lora_semi_bold
import com.core.designsystem.lora_semi_bold_italic
import com.core.designsystem.manrope_bold
import com.core.designsystem.manrope_extra_bold
import com.core.designsystem.manrope_extra_light
import com.core.designsystem.manrope_light
import com.core.designsystem.manrope_medium
import com.core.designsystem.manrope_regular
import com.core.designsystem.manrope_semi_bold
import org.jetbrains.compose.resources.Font

internal val bodyFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(
            resource = Res.font.manrope_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.manrope_extra_bold,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.manrope_extra_light,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.manrope_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.manrope_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.manrope_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.manrope_semi_bold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal,
        ),
    )

internal val displayFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(
            resource = Res.font.lora_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.lora_bold_italic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.lora_italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.lora_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.lora_medium_italic,
            weight = FontWeight.Medium,
            style = FontStyle.Italic,
        ),
        Font(
            resource = Res.font.lora_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.lora_semi_bold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.lora_semi_bold_italic,
            weight = FontWeight.SemiBold,
            style = FontStyle.Italic,
        ),
    )

private val baseline = Typography()

internal val CandyTypography: Typography
    @Composable
    get() = Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
        displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
        displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
        titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
        titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
        titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
        bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
        labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
        labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
        labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
    )


