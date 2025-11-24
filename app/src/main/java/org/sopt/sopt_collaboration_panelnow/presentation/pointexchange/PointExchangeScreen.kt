package org.sopt.sopt_collaboration_panelnow.presentation.pointexchange

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.component.MyPointCard
import org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.component.ProductCard
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import org.sopt.sopt_collaboration_panelnow.R

data class Product(
    val imageUrl: String,
    val title: String,
    val businessDays: Int,
    val points: Int
)

@Composable
fun PointExchangeRoute(
) {
    val dummyProducts = listOf(
        Product("", "현금 교환", 10, 2000),
        Product("", "굿네이버스 기부", 30, 100),
        Product("", "네이버페이 포인트쿠폰 3000원권", 3, 3200),
        Product("", "배스킨 라빈스 파인트 아이스크림", 3, 9800),
        Product("", "교촌 허니오리지날+콜라 1.25L", 3, 22000),
        Product("", "네이버페이 포인트쿠폰 5000원권", 3, 5000),
    )

    PointExchangeScreen(products = dummyProducts)
}

@Composable
fun PointExchangeScreen(
    products: List<Product>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PanelNowTheme.colors.gray4)
    ) {
        MyPointCard(
            currentPoint = 4500,
            exchangedPoint = 4000
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .background(
                    color = PanelNowTheme.colors.white,
                    shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                )
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 32.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_dropdown_popularity),
                contentDescription = "Dropdown",
                modifier = Modifier
                    .width(94.dp)
                    .height(32.dp),
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(24.dp),
                content = {
                    items(products) { product ->
                        ProductCard(
                            imageUrl = product.imageUrl,
                            title = product.title,
                            businessDays = product.businessDays,
                            points = product.points,
                            modifier = Modifier
                                .wrapContentWidth()
                        )
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PointExchangeScreenPreview() {
    val dummyProducts = listOf(
        Product("", "현금 교환", 10, 2000),
        Product("", "굿네이버스 기부", 30, 100),
        Product("", "네이버페이 포인트쿠폰 3000원권", 3, 3200),
        Product("", "배스킨 라빈스 파인트 아이스크림", 3, 9800),
        Product("", "교촌 허니오리지날+콜라 1.25L", 3, 22000),
        Product("", "네이버페이 포인트쿠폰 5000원권", 3, 5000),
    )

    PanelNowTheme {
        PointExchangeScreen(products = dummyProducts)
    }
}
