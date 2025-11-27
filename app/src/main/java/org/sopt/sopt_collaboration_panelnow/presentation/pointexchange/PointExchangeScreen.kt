package org.sopt.sopt_collaboration_panelnow.presentation.pointexchange

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.component.MyPointCard
import org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.component.ProductCard
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.sopt_collaboration_panelnow.core.designsystem.component.PanelNowTopBar
import org.sopt.sopt_collaboration_panelnow.domain.entity.Product
import androidx.compose.runtime.getValue
import androidx.compose.material3.Text
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import org.sopt.sopt_collaboration_panelnow.presentation.main.navigation.Detail
import org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.component.SortDropdown

@Composable
fun PointExchangeRoute(
    navController: NavHostController,
    viewModel: PointExchangeViewModel = hiltViewModel(),
) {
    val sortOption by viewModel.sortOption.collectAsStateWithLifecycle()
    val products by viewModel.products.collectAsStateWithLifecycle()
    val pointExchangeUiState by viewModel.pointExchangeUiState.collectAsStateWithLifecycle()
    val gridState = rememberLazyGridState()

    LaunchedEffect(Unit) {
        viewModel.getProducts(sortOption)
    }

    LaunchedEffect(Unit) {
        viewModel.getUserPoint()
    }

    LaunchedEffect(sortOption) {
        gridState.scrollToItem(0)
    }

    PointExchangeScreen(
        currentPoint = pointExchangeUiState.currentPoint,
        usedPoint = pointExchangeUiState.usedPoint,
        gridState = gridState,
        selectedSort = sortOption,
        products = products,
        onSortSelected = { selected ->
            viewModel.setSortOption(selected)
            viewModel.getProducts(selected)
        },
        onProductClick = { productId ->
            navController.navigate(Detail(pointExchangeUiState.currentPoint, productId))

        },
    )
}

@Composable
fun PointExchangeScreen(
    currentPoint: Int,
    usedPoint: Int,
    gridState: LazyGridState,
    selectedSort: String,
    products: List<Product>,
    onSortSelected: (String) -> Unit,
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
            currentPoint = currentPoint,
            usedPoint = usedPoint,
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
            SortDropdown(
                selectedSort = selectedSort,
                onSortSelected = onSortSelected,
                modifier = Modifier
                    .width(130.dp)
                    .height(36.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = gridState,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
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
            currentPoint = 4500,
            usedPoint = 4000,
            gridState = rememberLazyGridState(),
            selectedSort = "default",
            products = dummyProducts,
            onSortSelected = {},
            onProductClick = {},
        )
    }
}
