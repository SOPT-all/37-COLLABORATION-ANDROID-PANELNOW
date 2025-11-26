package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.common.util.maskPhoneNumber
import org.sopt.sopt_collaboration_panelnow.core.common.util.toPointFormat
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.domain.entity.GoodsCheck
import org.sopt.sopt_collaboration_panelnow.presentation.main.navigation.Exchange
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointCouponSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointGoodsSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointGuideSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointImageSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointPaySection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.viewmodel.PointDetailViewModel

@Composable
fun PointDetailRoute(
    currentPoint: Int,
    productId: Int,
    navController: NavController,
    viewModel: PointDetailViewModel = hiltViewModel(),
) {
    val goodsCheckState by viewModel.goodsCheckState.collectAsStateWithLifecycle()
    val purchaseSuccess by viewModel.purchaseSuccess.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getGoodsCheck(productId)
    }

    LaunchedEffect(purchaseSuccess) {
        if (purchaseSuccess) {
            navController.navigate(Exchange) {
                popUpTo(Exchange) {
                    inclusive = true
                }
            }
            viewModel.resetPurchaseSuccess()
        }
    }

    PointDetailScreen(
        goodsCheckState = goodsCheckState,
        onPurchaseClick = {
            viewModel.postPurchase(productId)
        }
    )
}

@Composable
fun PointDetailScreen(
    goodsCheckState: GoodsCheck,
    modifier: Modifier = Modifier,
    onPurchaseClick: () -> Unit = {},
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
                    couponPoint = goodsCheckState.price.toString().toPointFormat(),
                    phoneNumber = goodsCheckState.phoneNumber.maskPhoneNumber(),
                    exchangeDate = goodsCheckState.exchangeDay,
                    modifier = modifier
                )
            }

            item {
                PointGoodsSection()
            }

            item {
                PointGuideSection(
                    infoSections = goodsCheckState.infoSections
                )
            }

            item {
                Spacer(modifier = Modifier.height(36.dp))
            }
        }

        PointPaySection(
            label = "교환하기",
            myPoint = "5000",
            modifier = modifier
                .align(alignment = Alignment.BottomCenter),
            canPayed = true,
            iconRes = R.drawable.ic_point,
            onPayClick = onPurchaseClick
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
