package org.sopt.soptackthon_app_3.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.sopt.soptackthon_app_3.R

val SopkathonRegularFont = FontFamily(Font(R.font.pretendard_regular))

@Immutable
data class SopkathonTypography(
    val title: TextStyle,
    // 여기에 추가 해주시면 돼용
)

val defaultSopkathonTypography = SopkathonTypography(
    title = TextStyle(
        fontFamily = SopkathonRegularFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    // 여기에 추가
//    title_24Strong = TextStyle(
//    fontFamily = HsLinkSemiBoldFont,
//    fontWeight = FontWeight.SemiBold,
//    fontSize = 24.sp,
//    lineHeight = 34.sp,
//    letterSpacing = (-0.03).em
)

val LocalSopkathonTypography = staticCompositionLocalOf { defaultSopkathonTypography }