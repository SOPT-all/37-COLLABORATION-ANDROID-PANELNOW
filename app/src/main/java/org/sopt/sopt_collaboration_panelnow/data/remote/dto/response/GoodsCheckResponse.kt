package org.sopt.sopt_collaboration_panelnow.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoSectionResponse(
    @SerialName("label")
    val label: String,
    @SerialName("content")
    val content: String,
)

@Serializable
data class GoodsCheckResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Long,
    @SerialName("phoneNumber")
    val phoneNumber: String,
    @SerialName("exchangeDay")
    val exchangeDay: String,
    @SerialName("infoSections")
    val infoSections: List<InfoSectionResponse>
)