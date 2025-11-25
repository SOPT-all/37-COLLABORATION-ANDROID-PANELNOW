package org.sopt.sopt_collaboration_panelnow.data.mapper

import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.GoodsCheckResponse
import org.sopt.sopt_collaboration_panelnow.domain.entity.GoodsCheck

fun GoodsCheckResponse.toGoodsCheck(): GoodsCheck {
    val infoContent = infoSections.find { it.label == "충전권 이용안내" }?.content ?: ""
    val usageManualContent = infoSections.find { it.label == "사용방법" }?.content ?: ""
    val guideContent = infoSections.find { it.label == "이용가이드" }?.content ?: ""

    return GoodsCheck(
        id = id,
        imageUrl = imageUrl,
        name = name,
        price = price,
        phoneNumber = phoneNumber,
        exchangeDay = exchangeDay,
        info = infoContent,
        usageManual = usageManualContent,
        guide = guideContent,
    )
}