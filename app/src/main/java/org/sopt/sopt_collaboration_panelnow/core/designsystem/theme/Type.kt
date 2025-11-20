package org.sopt.sopt_collaboration_panelnow.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.sopt.sopt_collaboration_panelnow.R

val PANELNOWFontBold = FontFamily(Font(R.font.pretendard_bold))
val PANELNOWFontSemiBold = FontFamily(Font(R.font.pretendard_semibold))
val PANELNOWFontMedium = FontFamily(Font(R.font.pretendard_medium))
val PANELNOWFontRegular = FontFamily(Font(R.font.pretendard_regular))

@Immutable
data class PANELNOWTypography(
    val title_bd_24: TextStyle,
    val title_sb_20: TextStyle,
    val title_sb_16: TextStyle,
    val title_m_14: TextStyle,
    val title_m_12: TextStyle,

    val body_r_16: TextStyle,
    val body_r_14: TextStyle,
    val body_m_12: TextStyle,
    val body_m_10: TextStyle
)

val defaultPANELNOWTypography = PANELNOWTypography(
    title_bd_24 = TextStyle(
        fontFamily = PANELNOWFontBold,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    title_sb_20 = TextStyle(
        fontFamily = PANELNOWFontSemiBold,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    title_sb_16 = TextStyle(
        fontFamily = PANELNOWFontSemiBold,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    title_m_14 = TextStyle(
        fontFamily = PANELNOWFontMedium,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 12.6.sp,
        letterSpacing = 0.sp
    ),
    title_m_12 = TextStyle(
        fontFamily = PANELNOWFontMedium,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp
    ),

    body_r_16 = TextStyle(
        fontFamily = PANELNOWFontRegular,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    body_r_14 = TextStyle(
        fontFamily = PANELNOWFontRegular,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    ),
    body_m_12 = TextStyle(
        fontFamily = PANELNOWFontMedium,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp
    ),
    body_m_10 = TextStyle(
        fontFamily = PANELNOWFontMedium,
        fontWeight = FontWeight.W500,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    )
)

val LocalPANELNOWTypographyProvider = staticCompositionLocalOf { defaultPANELNOWTypography }
