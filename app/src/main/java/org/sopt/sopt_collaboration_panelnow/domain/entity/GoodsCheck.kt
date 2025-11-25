package org.sopt.sopt_collaboration_panelnow.domain.entity

data class GoodsCheck(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Long,
    val phoneNumber: String,
    val exchangeDay: String,
    val info: String,
    val usageManual: String,
    val guide: String,
) {
    companion object {
        val Empty = GoodsCheck(
            id = -1,
            imageUrl = "",
            name = "로딩 중...",
            price = 0L,
            phoneNumber = "",
            exchangeDay = "",
            info = "",
            usageManual = "",
            guide = "",
        )
    }
}