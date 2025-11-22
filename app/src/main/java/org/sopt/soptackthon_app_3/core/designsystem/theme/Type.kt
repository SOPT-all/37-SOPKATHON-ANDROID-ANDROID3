package org.sopt.soptackthon_app_3.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.soptackthon_app_3.R


object SopkathonRegularFont {
    val Bold = FontFamily(Font(R.font.roboto_bold))
    val Regular = FontFamily(Font(R.font.pretendard_regular))
    val SemiBold = FontFamily(Font(R.font.roboto_semibold))
    val Medium = FontFamily(Font(R.font.roboto_medium))

}

private fun SopkathonTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit = 1.5.em,
    letterSpacing: TextUnit
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)


sealed interface TypographyTokens {
    @Immutable
    data class Heading(
        val headingSb20: TextStyle,
        val headingSb18: TextStyle,
    )

    @Immutable
    data class Title(
        val titleB16: TextStyle,
        val titleB14: TextStyle,
        val titleSb16: TextStyle,
        val titleSb14: TextStyle,
        val titleSb12: TextStyle,
    )

    @Immutable
    data class Body(
        val bodyM16: TextStyle,
        val bodyM14: TextStyle,
        val bodyM13: TextStyle
    )

    @Immutable
    data class Caption(
        val captionM12: TextStyle,
        val captionR12: TextStyle
    )


}

@Immutable
data class SopkathonTypography(

    val heading: TypographyTokens.Heading,
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body,
    val caption: TypographyTokens.Caption
)

val defaultSopkathonTypography = SopkathonTypography(

    heading = TypographyTokens.Heading(
        headingSb20 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.SemiBold,
            fontSize = 16.sp,
            letterSpacing = 0.sp
        ),
        headingSb18 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.SemiBold,
            fontSize = 18.sp,
            letterSpacing = 0.sp
        )
    ),
    title = TypographyTokens.Title(
        titleB16 = SopkathonTextStyle(
            SopkathonRegularFont.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.sp
        ),
        titleB14 = SopkathonTextStyle(
            SopkathonRegularFont.Bold,
            fontSize = 14.sp,
            letterSpacing = (-1).sp
        ),
        titleSb16 = SopkathonTextStyle(
            SopkathonRegularFont.SemiBold,
            fontSize = 16.sp,
            letterSpacing = (-1).sp
        ),
        titleSb14 = SopkathonTextStyle(
            SopkathonRegularFont.SemiBold,
            fontSize = 14.sp,
            letterSpacing = (-1).sp
        ),
        titleSb12 = SopkathonTextStyle(
            SopkathonRegularFont.SemiBold,
            fontSize = 12.sp,
            letterSpacing = (-1).sp
        )
    ),

    body = TypographyTokens.Body(
        bodyM16 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Medium,
            fontSize = 16.sp,
            letterSpacing = (-2).sp
        ),
        bodyM14 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Medium,
            fontSize = 14.sp,
            letterSpacing = (-2).sp
        ),
        bodyM13 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Medium,
            fontSize = 13.sp,
            letterSpacing = (-2).sp
        )
    ),
    caption = TypographyTokens.Caption(
        captionM12 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Medium,
            fontSize = 12.sp,
            letterSpacing = (-2).sp
        ),
        SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Regular,
            fontSize = 12.sp,
            letterSpacing = (-2).sp
        ),
    )


)

val LocalSopkathonTypography = staticCompositionLocalOf { defaultSopkathonTypography }
