package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.R

@Composable
fun PointCouponSection(
    couponName: String,
    couponPoint: String,
    phoneNumber: String,
    exchangeDate: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(17.dp),
    ) {
        Text(
            text = couponName,
        )

        Text(
            text = stringResource(id = R.string.point_detail_description)
        )

        Text(
            text = couponPoint,
        )

        CouponInfo(
            phoneNumber = phoneNumber,
            exchangeDate = exchangeDate,
        )
    }
}

@Composable
private fun CouponInfo(
    phoneNumber: String,
    exchangeDate: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 7.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(9.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.point_detail_coupon_locate)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = phoneNumber
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_point_detail_arrow_right),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 7.dp
                ),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = R.string.point_detail_coupon_date)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = exchangeDate
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPointCouponSection() {
    PointCouponSection(
        couponName = "Sample Coupon",
        couponPoint = "1000 points",
        phoneNumber = "123-456-7890",
        exchangeDate = "2023-12-31",
    )
}