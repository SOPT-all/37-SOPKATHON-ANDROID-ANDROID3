package org.sopt.soptackthon_app_3.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


//primary Color
val primary_=Color(0xFF428FFF)

val primary_900=Color(0xFF101827)

val primary_800=Color(0xFF4B5563)

val primary_500=Color(0xFF9CA2AE)

val primary_300=Color(0xFFE5E7EA)

val primary_200=Color(0XFFF2F4F5)

val primary_100=Color(0XFFF8FAFB)


//secondary Color

val secondary_=Color(0xFFC8DCFE)


//black_white
val black_=Color(0xFF121212)
val white_=Color(0xFFFFFFFF)




@Immutable
data class SopkathonColor(

    val primary:Color=primary_,
    val primary900: Color=primary_900,
    val primary800: Color=primary_800,
    val primary500: Color= primary_500,
    val primary300: Color= primary_300,
    val primary200: Color=primary_200,
    val primary100: Color=primary_100,
    val black : Color=black_,
    val white : Color=white_

    )

val defaultSopkathonColor = SopkathonColor(

    primary_,
    primary900 = primary_900,
    primary800 = primary_800,
    primary500 = primary_500,
    primary300 = primary_300,
    primary200 = primary_200,
    primary_100,
    black = black_,
    white = white_
)


val LocalSopkathonColor = staticCompositionLocalOf { defaultSopkathonColor }
