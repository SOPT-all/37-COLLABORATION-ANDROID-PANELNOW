package org.sopt.sopt_collaboration_panelnow.domain.entity

data class GoodsCheck(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val phoneNumber: String,
    val exchangeDay: String,
    val infoSections: List<InfoSection>
) {
    companion object {
        val Empty = GoodsCheck(
            id = 0,
            imageUrl = "",
            name = "",
            price = 0,
            phoneNumber = "",
            exchangeDay = "",
            infoSections = emptyList()
        )
    }
}

data class InfoSection(
    val label: String,
    val content: String
)