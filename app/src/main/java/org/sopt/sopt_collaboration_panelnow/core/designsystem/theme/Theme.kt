package org.sopt.sopt_collaboration_panelnow.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun ProvidePANELNOWColorsAndTypography(
    colors: PANELNOWColors,
    typography: PANELNOWTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalPANELNOWColorsProvider provides colors,
        LocalPANELNOWTypographyProvider provides typography,
        content = content
    )
}

@Composable
fun SOPT_COLLABORATION_PANELNOWTheme(
    content: @Composable () -> Unit
) {
    ProvidePANELNOWColorsAndTypography(
        colors = defaultPANELNOWColors,
        typography = defaultPANELNOWTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
                }
            }
        }
    }
    MaterialTheme(
        content = content
    )
}