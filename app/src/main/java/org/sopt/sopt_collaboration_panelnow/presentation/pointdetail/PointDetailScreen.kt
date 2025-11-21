package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointCouponSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointGoodsSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointGuideSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointImageSection
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component.PointPaySection


@Composable
fun PointDetailRoute(
) {
    PointDetailScreen()
}

@Composable
fun PointDetailScreen(
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
                    color = Color.White
                )
        ) {
            item {
                PointImageSection(
                    pointImageUrl = "",
                )
            }
            item {
                PointCouponSection(
                    couponName = "Free Coffee Coupon",
                    couponPoint = "1000",
                    phoneNumber = "010-1234-5678",
                    exchangeDate = "2023-12-31",
                    modifier = modifier
                )
            }
            item {
                PointGoodsSection(
                    detailText = "This is a detailed description of the point goods.",
                )
            }
            item {
                PointGuideSection(
                    guideText = "This is a guide section for the point detail.",
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
    PointDetailScreen()
}