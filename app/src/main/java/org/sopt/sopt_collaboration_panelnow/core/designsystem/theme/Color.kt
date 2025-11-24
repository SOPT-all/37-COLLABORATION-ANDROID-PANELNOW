package org.sopt.sopt_collaboration_panelnow.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val MainBlue = Color(0xFF00A8FF)

val SubBlue = Color(0xFFC4EEFF)
val SubRed = Color(0xFFF55141)

val Gray1 = Color(0xFF96A1AA)
val Gray2 = Color(0xFFA2A2A2)
val Gray3 = Color(0xFFEBEBEB)
val Gray4 = Color(0xFFF2F4F5)
val Gray5 = Color(0xFFE1ECF4)
val Gray6 = Color(0xFF00152C)

val White = Color(0xFFFFFFFF)

@Immutable
data class PanelNowColors(
    val mainBlue: Color,

    val subBlue: Color,
    val subRed: Color,

    val gray1: Color,
    val gray2: Color,
    val gray3: Color,
    val gray4: Color,
    val gray5: Color,
    val gray6: Color,

    val white: Color
)

val defaultPanelNowColors = PanelNowColors(
    mainBlue = MainBlue,

    subBlue = SubBlue,
    subRed = SubRed,

    gray1 = Gray1,
    gray2 = Gray2,
    gray3 = Gray3,
    gray4 = Gray4,
    gray5 = Gray5,
    gray6 = Gray6,

    white = White
)

val LocalPanelNowColorsProvider = staticCompositionLocalOf { defaultPanelNowColors }
