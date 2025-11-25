package org.sopt.sopt_collaboration_panelnow.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int,
    @SerialName("day")
    val day: String
)
