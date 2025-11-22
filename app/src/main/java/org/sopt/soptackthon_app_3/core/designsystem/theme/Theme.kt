package org.sopt.soptackthon_app_3.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object SopkathonTheme {
    val colors: SopkathonColor
        @Composable
        @ReadOnlyComposable
        get() = LocalSopkathonColor.current

    val typography: SopkathonTypography
        @Composable
        @ReadOnlyComposable
        get() =  LocalSopkathonTypography.current
}

@Composable
fun ProvideSopkathonColorsAndTypographt(
    colors: SopkathonColor,
    typography: SopkathonTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalSopkathonColor provides colors,
        LocalSopkathonTypography provides typography,
        content = content
    )
}

@Composable
fun SopkathonTheme(
    content: @Composable () -> Unit,
) {
    ProvideSopkathonColorsAndTypographt(
        colors = defaultSopkathonColor,
        typography = defaultSopkathonTypography,
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
                }
            }
        }
        MaterialTheme(
            content = content
        )
    }
}
