package org.sopt.soptackthon_app_3.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)

// 여기에 Color 코드

@Immutable
data class SopkathonColor(
    val Black : Color,
    val White : Color
    // 요로코롬
)

val defaultSopkathonColor = SopkathonColor(
    Black = Black,
    White = White
    // 요런식으로
)


val LocalSopkathonColor = staticCompositionLocalOf { defaultSopkathonColor }