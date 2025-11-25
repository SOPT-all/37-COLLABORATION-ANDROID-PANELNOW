package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.domain.entity.GoodsCheck
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointCouponSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointGoodsSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointGuideSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointImageSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointPaySection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.viewmodel.PointDetailViewModel


@Composable
fun PointDetailRoute(
    productId: Int,
    viewModel: PointDetailViewModel = hiltViewModel(),
) {
    val goodsCheckState by viewModel.goodsCheckState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getGoodsCheck(productId)
    }

    PointDetailScreen(
        goodsCheckState = goodsCheckState
    )
}

@Composable
fun PointDetailScreen(
    goodsCheckState: GoodsCheck,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = PanelNowTheme.colors.gray4
                ),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            item {
                PointImageSection(
                    pointImageUrl = goodsCheckState.imageUrl,
                )
            }
            item {
                PointCouponSection(
                    couponName = goodsCheckState.name,
                    couponPoint = goodsCheckState.price.toString(),
                    phoneNumber = goodsCheckState.phoneNumber,
                    exchangeDate = goodsCheckState.exchangeDay,
                    modifier = modifier
                )
            }
            item {
                PointGoodsSection(
                    detailText = goodsCheckState.info,
                )
            }
            item {
                PointGuideSection(
                    guideText = goodsCheckState.guide,
                )
            }
        }

        PointPaySection(
            label = "Pay with Points",
            myPoint = "5000",
            modifier = modifier
                .align(alignment = Alignment.BottomCenter),
            canPayed = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPointdetailScreen() {
    PanelNowTheme {
        PointDetailScreen(goodsCheckState = GoodsCheck.Empty)
    }
}