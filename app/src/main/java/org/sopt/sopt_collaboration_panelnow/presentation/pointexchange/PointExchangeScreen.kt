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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.designsystem.component.PanelNowTopBar
import org.sopt.sopt_collaboration_panelnow.domain.entity.Product
import androidx.compose.runtime.getValue
import androidx.compose.material3.Text
import androidx.navigation.NavHostController
import org.sopt.sopt_collaboration_panelnow.presentation.home.viewmodel.HomeViewModel
import org.sopt.sopt_collaboration_panelnow.presentation.main.navigation.Detail

@Composable
fun PointExchangeRoute(
    navController: NavHostController,
    viewModel: PointExchangeViewModel = hiltViewModel(),
) {
    val products by viewModel.products.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getProducts("default")
    }

    PointExchangeScreen(
        products = products,
        onProductClick = { productId ->
            navController.navigate(Detail(productId))

        }
    )
}

@Composable
fun PointExchangeScreen(
    products: List<Product>,
    onProductClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PanelNowTheme.colors.gray4)
    ) {
        PanelNowTopBar(
            content = {
                Text(
                    text = "포인트 교환",
                    style = PanelNowTheme.typography.titleSb16,
                    color = PanelNowTheme.colors.gray6
                )
            }
        )

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
                .padding(top = 16.dp)
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
                            title = product.name,
                            businessDays = product.day,
                            points = product.price,
                            modifier = Modifier.wrapContentWidth(),
                            onClick = {
                                onProductClick(product.id)
                            },
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
        Product(-1, "", "현금 교환", 2000, "10"),
        Product(-1, "", "굿네이버스 기부", 100, "30"),
        Product(-1, "", "네이버페이 포인트쿠폰 3000원권", 3200, "3"),
        Product(-1, "", "배스킨 라빈스 파인트 아이스크림", 9800, "3"),
        Product(-1, "", "교촌 허니오리지날+콜라 1.25L", 22000, "3"),
        Product(-1, "", "네이버페이 포인트쿠폰 5000원권", 5000, "3"),
    )

    PanelNowTheme {
        PointExchangeScreen(
            products = dummyProducts,
            onProductClick = {},
        )
    }
}
