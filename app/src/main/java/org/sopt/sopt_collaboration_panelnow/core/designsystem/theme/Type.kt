package org.sopt.sopt_collaboration_panelnow.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.sopt.sopt_collaboration_panelnow.R

val PanelNowFontBold = FontFamily(Font(R.font.pretendard_bold))
val PanelNowFontSemiBold = FontFamily(Font(R.font.pretendard_semibold))
val PanelNowFontMedium = FontFamily(Font(R.font.pretendard_medium))
val PanelNowFontRegular = FontFamily(Font(R.font.pretendard_regular))

@Immutable
data class PanelNowTypography(
    val titleBd24: TextStyle,
    val titleSb20: TextStyle,
    val titleSb16: TextStyle,
    val titleM14: TextStyle,
    val titleM12: TextStyle,

    val bodyR16: TextStyle,
    val bodyR14: TextStyle,
    val bodyM12: TextStyle,
    val bodyM10: TextStyle
)

val defaultPanelNowTypography = PanelNowTypography(
    titleBd24 = TextStyle(
        fontFamily = PanelNowFontBold,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    titleSb20 = TextStyle(
        fontFamily = PanelNowFontSemiBold,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    titleSb16 = TextStyle(
        fontFamily = PanelNowFontSemiBold,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    titleM14 = TextStyle(
        fontFamily = PanelNowFontMedium,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 12.6.sp,
        letterSpacing = 0.sp
    ),
    titleM12 = TextStyle(
        fontFamily = PanelNowFontMedium,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp
    ),

    bodyR16 = TextStyle(
        fontFamily = PanelNowFontRegular,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    bodyR14 = TextStyle(
        fontFamily = PanelNowFontRegular,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    ),
    bodyM12 = TextStyle(
        fontFamily = PanelNowFontMedium,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp
    ),
    bodyM10 = TextStyle(
        fontFamily = PanelNowFontMedium,
        fontWeight = FontWeight.W500,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    )
)

val LocalPanelNowTypographyProvider = staticCompositionLocalOf { defaultPanelNowTypography }
