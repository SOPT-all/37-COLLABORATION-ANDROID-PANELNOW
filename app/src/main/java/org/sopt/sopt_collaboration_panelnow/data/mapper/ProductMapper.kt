package org.sopt.sopt_collaboration_panelnow.data.mapper

import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.ProductResponse
import org.sopt.sopt_collaboration_panelnow.domain.entity.Product

fun ProductResponse.toProduct(): Product {
    return Product(
        id = this.id,
        imageUrl = this.imageUrl,
        name = this.name,
        price = this.price,
        day = this.day,
    )
}
