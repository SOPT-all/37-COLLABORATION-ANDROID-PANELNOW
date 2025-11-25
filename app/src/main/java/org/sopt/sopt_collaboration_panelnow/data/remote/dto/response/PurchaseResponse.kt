package org.sopt.sopt_collaboration_panelnow.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PurchaseResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String
)