package org.sopt.sopt_collaboration_panelnow.data.mapper

import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.GoodsCheckResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.InfoSectionResponse
import org.sopt.sopt_collaboration_panelnow.domain.entity.GoodsCheck
import org.sopt.sopt_collaboration_panelnow.domain.entity.InfoSection

fun GoodsCheckResponse.toGoodsCheck(): GoodsCheck {
    return GoodsCheck(
        id = id,
        imageUrl = imageUrl,
        name = name,
        price = price.toInt(),
        phoneNumber = phoneNumber,
        exchangeDay = exchangeDay,
        infoSections = infoSections.map { it.toInfoSection() }
    )
}

fun InfoSectionResponse.toInfoSection(): InfoSection {
    return InfoSection(
        label = label,
        content = content
    )
}