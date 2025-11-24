package org.sopt.sopt_collaboration_panelnow.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


object PanelNowTheme {
    val colors: PanelNowColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPanelNowColorsProvider.current
    val typography: PanelNowTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalPanelNowTypographyProvider.current
}

@Composable
fun ProvidePanelNowColorsAndTypography(
    colors: PanelNowColors,
    typography: PanelNowTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalPanelNowColorsProvider provides colors,
        LocalPanelNowTypographyProvider provides typography,
        content = content
    )
}

@Composable
fun PanelNowTheme(
    content: @Composable () -> Unit,
) {
    ProvidePanelNowColorsAndTypography(
        colors = defaultPanelNowColors,
        typography = defaultPanelNowTypography
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